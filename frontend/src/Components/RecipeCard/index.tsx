import { Recipe, User } from "types";
import './styles.css';
import starIcon from 'assets/images/star.png';
import like from 'assets/images/like.png';
import likeFilled from 'assets/images/like_filled.png';
import { useCallback, useEffect, useState } from "react";
import { requestBackend } from "util/requests";
import { AxiosRequestConfig } from "axios";
import { getTokenData } from "util/auth";
import { Link } from "react-router-dom";

type Props = {
    recipe: Recipe;
    onUpdateFavorite: Function;
}

const RecipeCard = ({recipe, onUpdateFavorite} : Props) => {

    const [user, setUser] = useState<User | null>(null);

    const getUser = useCallback(async () => {
      try {
        const email = getTokenData()?.user_name;
  
        if (email) {
          const params: AxiosRequestConfig = {
            method: "GET",
            url: `/users/email/${email}`,
            withCredentials: true,
          };
  
          const response = await requestBackend(params);
          setUser(response.data);
        }
      } catch (error) {
        console.log("Error: " + error);
      }
    }, []);
  
    useEffect(() => {
      getUser();
    }, [getUser]);

    const plotStars = (quantity: number) => {
        const arrayImages = Array.from({length: quantity});

        return(
            <div style={{display:"flex", flexDirection:"row"}}>
                {quantity !== 0 ? 
                    arrayImages.map((_) => (
                        <img src={starIcon} alt="" style={{height:"20px", marginLeft:"5px"}}/>
                    )) : 
                        <p style={{marginLeft:"5px"}}>0</p>
                }
            </div>
        );
    }

    const addRecipeAsFavorite = () => {
        const params : AxiosRequestConfig = {
            method:"PUT",
            url: `/recipes/addFavorite/${recipe.id}`,
            withCredentials:true
          }
          requestBackend(params) 
            .then(response => {
                onUpdateFavorite();
            })
    }

    const removeRecipeAsFavorite = () => {
        const params : AxiosRequestConfig = {
            method:"PUT",
            url: `/recipes/removeFavorite/${recipe.id}`,
            withCredentials:true
          }
          requestBackend(params) 
            .then(response => {
                onUpdateFavorite();
            })
    }
    
    return(
        <div className="recipe-card-container" style={{backgroundImage: `url(${recipe.imgUrl})`,
        backgroundRepeat: "no-repeat",
        backgroundSize: "cover",
        }}>
            <div className="recipe-card-content">
                <div className="recipe-card-first-container">
                    <Link to={`/recipes/${recipe.id}`}>
                        <div className="recipe-card-title">
                            <h4>{recipe.name}</h4>
                        </div>
                    </Link>
                    <div className="recipe-card-buttons">
                        {user && recipe.usersFavoritedId.includes(user?.id) ? (
                            <img src={likeFilled} alt="" onClick={() => removeRecipeAsFavorite()}/>
                        ) : (
                            <img src={like} alt="" onClick={() => addRecipeAsFavorite()}/>
                        )}
                        <p>{recipe.usersFavoritedId.length}</p>
                    </div>
                </div>
                <div className="recipe-card-second-container">
                    {plotStars(recipe.pontuationAverage)}
                </div>

            </div>
        </div>
    );
}

export default RecipeCard;