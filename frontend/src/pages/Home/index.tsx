import logo from 'assets/images/recipe-logo.png'
import './styles.css';
import background from 'assets/images/home-background.png';
import TopNavbar from 'pages/Home/TopNavbar';
import { isAuthenticated } from 'util/auth';
import { Link } from 'react-router-dom';

const Home = () => {
    return(
        <div className='home-page'>
            <TopNavbar/>
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
                        {isAuthenticated() ? (
                            <Link to={`/recipes`}>
                                <button className='btn btn-primary btn-home'>Start cooking!</button>
                            </Link>
                        ) : (
                            <Link to={`/auth`}>
                                <button className='btn btn-primary btn-home'>Start cooking!</button>
                            </Link>
                        )}
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Home;