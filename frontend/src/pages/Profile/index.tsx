import { useCallback, useEffect, useState } from 'react';
import './styles.css';
import { User } from 'types';
import { getTokenData } from 'util/auth';
import { AxiosRequestConfig } from 'axios';
import { requestBackend } from 'util/requests';

const Profile = () => {

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

    return(
        <div className='profile-container'>
            <div className='profile-user-info base-card'>
                <img src={user?.imgUrl} alt="" />
                <h2>{user?.name}</h2>
                <p>{user?.email}</p>
                <div className='profile-user-badge'>
                    <div className='profile-badge-item'>
                        <h5>{user?.recipes.length}</h5>
                        <p>Recipes</p>
                    </div>
                    <p className='recipe-info-item-separator'></p>
                    <div className='profile-badge-item'>
                        <h5>{user?.favoritesId.length}</h5>
                        <p>Favorites</p>
                    </div>
                    <p className='recipe-info-item-separator'></p>
                    <div className='profile-badge-item'>
                        <h5>{user?.feedbacksId.length}</h5>
                        <p>Feedbacks</p>
                    </div>
                </div>
                <div className='profile-user-edit'>
                    <button className='btn btn-primary'>Edit Profile</button>
                </div>
            </div>
            <div className='profile-user-recipes'>
                <div className='profile-my-recipes'>

                </div>
                <div className='profile-favorited-recipes'>

                </div>
            </div>
        </div>
    );
}

export default Profile;