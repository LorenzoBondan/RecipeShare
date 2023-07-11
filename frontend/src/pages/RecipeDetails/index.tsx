
import { useParams } from 'react-router-dom';
import './styles.css';
import { useCallback, useEffect, useState } from 'react';
import { Recipe, User } from 'types';
import { AxiosRequestConfig } from 'axios';
import { requestBackend } from 'util/requests';
import { getTokenData } from 'util/auth';
import starIcon from 'assets/images/star.png';
import like from 'assets/images/like.png';
import likeFilled from 'assets/images/like_filled.png';
import { toast } from 'react-toastify';

type UrlParams = {
    recipeId: string;
  }

const RecipeDetails = () => {

    const { recipeId } = useParams<UrlParams>();

    const [recipe, setRecipe] = useState<Recipe>();

    const getRecipe = useCallback(async () => {
        try {
            const params: AxiosRequestConfig = {
            method: "GET",
            url: `/recipes/${recipeId}`,
            withCredentials: true,
        };
  
        const response = await requestBackend(params);
        setRecipe(response.data);
        
        } catch (error) {
            console.log("Error: " + error);
        }
    }, [recipeId]);

    useEffect(() => {
        getRecipe();
    }, [getRecipe]);

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
                        <p></p>
                }
            </div>
        );
    };

    const [creator, setCreator] = useState<User | null>(null);

    const getCreator = useCallback(async () => {
        try {
            if (recipe) {
                const params: AxiosRequestConfig = {
                method: "GET",
                url: `/users/${recipe.authorId}`,
                withCredentials: true,
                };

                const response = await requestBackend(params);
                setCreator(response.data);
            }
        } catch (error) {
            console.log("Error: " + error);
        }
    }, [recipe]);

    useEffect(() => {
        getCreator();
    }, [getCreator]);

    const addRecipeAsFavorite = () => {
        const params : AxiosRequestConfig = {
            method:"PUT",
            url: `/recipes/addFavorite/${recipe?.id}`,
            withCredentials:true
          }
          requestBackend(params) 
            .then(response => {
                getRecipe();
                toast.info(`${recipe?.name} added to your favorites!`, {
                    className: 'custom-toast',
                    bodyClassName: 'custom-toast-body',
                });
            })
    }

    const removeRecipeAsFavorite = () => {
        const params : AxiosRequestConfig = {
            method:"PUT",
            url: `/recipes/removeFavorite/${recipe?.id}`,
            withCredentials:true
          }
          requestBackend(params) 
            .then(response => {
                getRecipe();
                toast.info(`${recipe?.name} removed from your favorites!`, {
                    className: 'custom-toast',
                    bodyClassName: 'custom-toast-body-removed',
                });
            })
    }

    const numberOfIngredients = recipe?.ingredients.split(',').length;
    const ingredients = recipe?.ingredients.split(',');

    function capitalizeFirstLetter(str: string): string {
        return str.replace(/(?:^|\s)\S/g, (match) => match.toUpperCase());
    }

    return(
        <div className='recipe-details-container'>
            <div className='recipe-info-container '>
                <div className='recipe-info-content'>
                    <div className='recipe-info-title'>
                        <h1>{recipe?.name}</h1>
                        {recipe && recipe?.feedbacks.length > 0 && 
                            <div className='recipe-info-feedback'>
                                {recipe && plotStars(recipe?.pontuationAverage)}
                                <p>({recipe?.pontuationAverage})</p>
                            </div>
                        }
                    </div>
                    <div className='recipe-info-time'>
                        <div className='recipe-info-item'>
                            <h5>{recipe?.time}</h5>
                            <p>Minutes</p>
                        </div>
                        <span className='recipe-info-item-separator'></span>
                        <div className='recipe-info-item'>
                            <h5>{numberOfIngredients}</h5>
                            <p>Ingredients</p>
                        </div>
                        <span className='recipe-info-item-separator'></span>
                        <div className='recipe-info-item'>
                            <h5>{recipe?.feedbacks.length}</h5>
                            <p>Feedbacks</p>
                        </div>
                    </div>
                    <div className='recipe-info-feedback-buttons'>
                        <button className='btn btn-primary'>Give a Feedback</button>
                        <div className='recipe-info-buttons'>
                            {user && recipe?.usersFavoritedId.includes(user?.id) ? (
                                <img src={likeFilled} alt="" onClick={() => removeRecipeAsFavorite()}/>
                            ) : (
                                <img src={like} alt="" onClick={() => addRecipeAsFavorite()}/>
                            )}
                            <p>{recipe?.usersFavoritedId.length}</p>
                        </div>
                        <div className='recipe-info-creator'>   
                            <p>Published by</p>
                            <img src={creator?.imgUrl} alt="" />
                            <h6>{creator?.name}</h6>
                        </div>
                    </div>
                    
                </div>
                <div className='recipe-image'>
                    <img src={recipe?.imgUrl} alt="" />
                </div>
            </div>
            <div className='recipe-details-ingredients-preparation-container '>
                <div className='recipe-details-ingredients-container'>
                    <h3>Ingredients</h3>
                    {ingredients?.map(ingredient => (
                        <p key={ingredient}>- {capitalizeFirstLetter(ingredient)}</p>
                    ))}
                </div>
                <div className='recipe-details-preparation-container'>
                    <h3>Preparation Mode</h3>
                    <p>- {recipe?.preparation}</p>
                </div>
            </div>
            <div className='recipe-details-tags-container '>
                <h3>Recipe tags</h3>
                <ul className='recipe-tags'>
                    {recipe?.categories.map(category => (
                        <li>
                            <p key={category.id}>{category.name}</p>
                        </li>
                    ))}
                </ul>
            </div>
            <div className='recipe-details-feedbacks-container'>
                <h3>Reviews ({recipe?.feedbacks.length})</h3>
            </div>
        </div>
    );
}

export default RecipeDetails;