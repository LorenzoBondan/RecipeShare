INSERT INTO tb_user (name, email, password, img_Url) VALUES ('Alex', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'https://xsgames.co/randomusers/assets/avatars/male/47.jpg');
INSERT INTO tb_user (name, email, password, img_Url) VALUES ('Maria', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'https://i.pinimg.com/originals/76/ef/b7/76efb7c94755748d695d3d46cf11d08d.jpg');
INSERT INTO tb_user (name, email, password, img_Url) VALUES ('Bob', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'https://xsgames.co/randomusers/assets/avatars/male/62.jpg');
INSERT INTO tb_user (name, email, password, img_url) VALUES ('John Doe', 'john.doe@example.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'https://xsgames.co/randomusers/assets/avatars/male/55.jpg');
INSERT INTO tb_user (name, email, password, img_url) VALUES ('Jane Smith', 'jane.smith@example.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'https://xsgames.co/randomusers/assets/avatars/female/2.jpg');
INSERT INTO tb_user (name, email, password, img_url) VALUES ('Michael Johnson', 'michael.johnson@example.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'https://xsgames.co/randomusers/assets/avatars/male/29.jpg');
INSERT INTO tb_user (name, email, password, img_url) VALUES ('Emily Davis', 'emily.davis@example.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'https://xsgames.co/randomusers/assets/avatars/female/18.jpg');
INSERT INTO tb_user (name, email, password, img_url) VALUES ('Robert Wilson', 'robert.wilson@example.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'https://xsgames.co/randomusers/assets/avatars/male/21.jpg');
INSERT INTO tb_user (name, email, password, img_url) VALUES ('Olivia Martinez', 'olivia.martinez@example.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'https://xsgames.co/randomusers/assets/avatars/female/55.jpg');
INSERT INTO tb_user (name, email, password, img_url) VALUES ('William Anderson', 'william.anderson@example.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'https://xsgames.co/randomusers/assets/avatars/male/38.jpg');
INSERT INTO tb_user (name, email, password, img_url) VALUES ('Sophia Thomas', 'sophia.thomas@example.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'https://xsgames.co/randomusers/assets/avatars/female/44.jpg');
INSERT INTO tb_user (name, email, password, img_url) VALUES ('David Jackson', 'david.jackson@example.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'https://xsgames.co/randomusers/assets/avatars/male/45.jpg');
INSERT INTO tb_user (name, email, password, img_url) VALUES ('Emma White', 'emma.white@example.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'https://xsgames.co/randomusers/assets/avatars/female/65.jpg');
INSERT INTO tb_user (name, email, password, img_url) VALUES ('Daniel Harris', 'daniel.harris@example.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'https://xsgames.co/randomusers/assets/avatars/male/73.jpg');
INSERT INTO tb_user (name, email, password, img_url) VALUES ('Mia Clark', 'mia.clark@example.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'https://xsgames.co/randomusers/assets/avatars/female/9.jpg');
INSERT INTO tb_user (name, email, password, img_url) VALUES ('Frank Joe', 'frank.joe@example.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'https://xsgames.co/randomusers/assets/avatars/male/53.jpg');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (4, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (5, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (6, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (7, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (8, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (9, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (10, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (11, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (12, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (13, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (14, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (15, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (16, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (16, 2);

INSERT INTO tb_category (name) VALUES ('Lunch');
INSERT INTO tb_category (name) VALUES ('Dinner');
INSERT INTO tb_category (name) VALUES ('Breakfast');
INSERT INTO tb_category (name) VALUES ('Fast Food');
INSERT INTO tb_category (name) VALUES ('Healthy Food');
INSERT INTO tb_category (name) VALUES ('Low Carb');
INSERT INTO tb_category (name) VALUES ('Deserts');

INSERT INTO tb_recipe (name, ingredients, preparation, time, img_Url, author_id) 
VALUES ('Pizza', 'Dough, cheese, tomato sauce, toppings', 'Prepare the dough, add toppings, bake', 30, 'https://www.example.com/cookies.jpg', 2);

INSERT INTO tb_recipe (name, ingredients, preparation, time, img_Url, author_id) 
VALUES ('Spaghetti Carbonara', 'Pasta, eggs, bacon, cheese, black pepper', 'Cook pasta, fry bacon, mix eggs and cheese, combine all ingredients', 20, 'https://www.example.com/spaghetti.jpg', 3);

INSERT INTO tb_recipe (name, ingredients, preparation, time, img_Url, author_id) 
VALUES ('Chicken Stir-Fry', 'Chicken, vegetables, soy sauce, garlic, ginger', 'Cook chicken, sauté vegetables, add sauce and spices', 25, 'https://www.example.com/cookies.jpg', 1);

INSERT INTO tb_recipe (name, ingredients, preparation, time, img_Url, author_id) 
VALUES ('Chocolate Chip Cookies', 'Flour, butter, sugar, chocolate chips', 'Mix ingredients, shape dough into cookies, bake', 15, 'https://www.example.com/cookies.jpg', 10);

INSERT INTO tb_recipe_favorited (recipe_id, user_id) VALUES (1, 2);
INSERT INTO tb_recipe_favorited (recipe_id, user_id) VALUES (2, 3);
INSERT INTO tb_recipe_favorited (recipe_id, user_id) VALUES (3, 4);
INSERT INTO tb_recipe_favorited (recipe_id, user_id) VALUES (1, 5);
INSERT INTO tb_recipe_favorited (recipe_id, user_id) VALUES (1, 6);
INSERT INTO tb_recipe_favorited (recipe_id, user_id) VALUES (2, 7);


INSERT INTO tb_feedback (comment, pontuation, moment, recipe_id, user_id) 
VALUES ('Delicious!', 4, TIMESTAMP WITH TIME ZONE '2023-07-09T14:30:00', 1, 1);

INSERT INTO tb_feedback (comment, pontuation, moment, recipe_id, user_id) 
VALUES ('Needs more cheese', 3, TIMESTAMP WITH TIME ZONE '2023-07-09T16:45:10', 1, 3);

INSERT INTO tb_feedback (comment, pontuation, moment, recipe_id, user_id) 
VALUES ('Authentic Italian taste', 5, TIMESTAMP WITH TIME ZONE '2023-07-09T17:10:55', 2, 8);

INSERT INTO tb_feedback (comment, pontuation, moment, recipe_id, user_id) 
VALUES ('Too salty', 2, TIMESTAMP WITH TIME ZONE '2023-07-09T19:20:30', 2, 5);

INSERT INTO tb_feedback (comment, pontuation, moment, recipe_id, user_id) 
VALUES ('Quick and delicious', 4, TIMESTAMP WITH TIME ZONE '2023-07-09T20:15:00', 3, 7);

INSERT INTO tb_feedback (comment, pontuation, moment, recipe_id, user_id) 
VALUES ('Not enough flavor', 3, TIMESTAMP WITH TIME ZONE '2023-07-09T22:05:40', 3, 8);

INSERT INTO tb_feedback (comment, pontuation, moment, recipe_id, user_id) 
VALUES ('Best cookies ever!', 5, TIMESTAMP WITH TIME ZONE '2023-07-09T18:40:20', 4, 9);

INSERT INTO tb_feedback (comment, pontuation, moment, recipe_id, user_id) 
VALUES ('Too sweet', 3, TIMESTAMP WITH TIME ZONE '2023-07-09T21:30:15', 4, 3);

INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (1, 4);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (1, 1);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (2, 1);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (3, 1);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (3, 4);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (4, 7);
