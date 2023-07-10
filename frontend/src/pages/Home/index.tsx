import logo from 'assets/images/recipe-logo.png'
import './styles.css';
import { Link } from 'react-router-dom';
import background from 'assets/images/home-background.png';

const Home = () => {
    return(
        <div className='home-page'>
            <div className="home-container" style={{backgroundImage: `url(${background})`,
                backgroundRepeat: "no-repeat",
                backgroundSize: "cover",
            }}>
                <div className='home-first-container'>
                    <h1>Welcome to RecipeShare</h1>
                    <span className='home-separator'></span>
                    <p>Share and discover new recipes</p>
                </div>
                <div className='home-second-container'>
                    <div className='home-second-container-logo'>
                        <img src={logo} alt="logo" />
                    </div>
                    <div className='home-second-container-content'>
                        <button className='btn btn-primary btn-home'>Start cooking!</button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Home;