import { Recipe } from "types";
import './styles.css';
import starIcon from 'assets/images/star.png';
import like from 'assets/images/like.png';
import likeFilled from 'assets/images/like_filled.png';

type Props = {
    recipe: Recipe;
}

const RecipeCard = ({recipe} : Props) => {

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
    
    return(
        <div className="recipe-card-container" style={{backgroundImage: `url(${recipe.imgUrl})`,
        backgroundRepeat: "no-repeat",
        backgroundSize: "cover",
        }}>
            <div className="recipe-card-content">
                <div className="recipe-card-first-container">
                    <div className="recipe-card-title">
                        <h4>{recipe.name}</h4>
                    </div>
                    <div className="recipe-card-buttons">
                        <button className="btn btn-primary">abc</button>
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