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
INSERT INTO tb_category (name) VALUES ('Salads');
INSERT INTO tb_category (name) VALUES ('Seafood');
INSERT INTO tb_category (name) VALUES ('Vegetarian');
INSERT INTO tb_category (name) VALUES ('Vegan');
INSERT INTO tb_category (name) VALUES ('Mexican');
INSERT INTO tb_category (name) VALUES ('Asian');
INSERT INTO tb_category (name) VALUES ('Mediterranean');

INSERT INTO tb_recipe (name, ingredients, preparation, time, img_Url, author_id) 
VALUES ('Pizza', 'Dough, cheese, tomato sauce, toppings', 'Prepare the dough, add toppings, bake', 30, 'https://lh3.googleusercontent.com/--tmigcjEYYptuQfKJOxdamEqn9KS0Pw3x7V9mWcMAxgOKwEgW2Gffmqf7GpkV0H_QQ-9t0eFSuOmX3Bxrcj_w=w640-h640-c-rw-v1-e365', 2);

INSERT INTO tb_recipe (name, ingredients, preparation, time, img_Url, author_id) 
VALUES ('Spaghetti Carbonara', 'Pasta, eggs, bacon, cheese, black pepper', 'Cook pasta, fry bacon, mix eggs and cheese, combine all ingredients', 20, 'https://lh3.googleusercontent.com/YIqcvVrsuolBDPUWdiBNv9WkF41D-TSxC_QtG6plEt-EZJQLrWiE-R9QBVJzHDBtJN8O5r_OKZdZR9zFFp7q=w640-h640-c-rw-v1-e365', 3);

INSERT INTO tb_recipe (name, ingredients, preparation, time, img_Url, author_id) 
VALUES ('Chicken Stir-Fry', 'Chicken, vegetables, soy sauce, garlic, ginger', 'Cook chicken, sauté vegetables, add sauce and spices', 25, 'https://lh3.googleusercontent.com/PiJRhjyU8iPdYzkIjfURFm739338nzBUOMg9RFfYbXDLOB6339updYT1ca8JzHhbwdO-DLrTzeZxM1Sin3eiDE4=w640-h640-c-rw-v1-e365', 1);

INSERT INTO tb_recipe (name, ingredients, preparation, time, img_Url, author_id) 
VALUES ('Chocolate Chip Cookies', 'Flour, butter, sugar, chocolate chips', 'Mix ingredients, shape dough into cookies, bake', 15, 'https://lh5.ggpht.com/hLnkyyRWXM5WNR1Wo1tArzFLAqCsBq2C2hFc3KgyNKaKajsNR8ks4A9JMS7dL18sQvD5MZlsWyzWKuBrtvyczQ=w640-h640-c-rw-v1-e365', 10);

INSERT INTO tb_recipe (name, ingredients, preparation, time, img_Url, author_id) 
VALUES ('Caesar Salad', 'Romaine lettuce, croutons, Parmesan cheese, Caesar dressing', 'Toss lettuce, add croutons and cheese, mix with dressing', 15, 'https://lh3.googleusercontent.com/DPyu6jv10giX4nl1XlkO_Ny9NJVIKKhVpFjNbmWF6-9Ks9an6tk1nmUiFlYJ5SlTiBipcVwJGfQlJJUt_jvXEw=w640-h640-c-rw-v1-e365', 6);

INSERT INTO tb_recipe (name, ingredients, preparation, time, img_Url, author_id) 
VALUES ('Grilled Salmon', 'Salmon fillet, lemon, olive oil, salt, pepper', 'Season salmon, grill with lemon and olive oil', 20, 'https://lh3.googleusercontent.com/qTBcRna0G4LkMOet-Mst3g553iG9Xq4lInkG9kCylOjm85U4HqVrvvI7uPNG-y2yATxtWMgCzCRKZEImvFG047ld9Lbx0WqCaIQ=w640-h640-c-rw-v1-e365', 5);

INSERT INTO tb_recipe (name, ingredients, preparation, time, img_Url, author_id) 
VALUES ('Roasted Vegetables', 'Assorted vegetables (carrots, bell peppers, zucchini, onions), olive oil, salt, pepper', 'Chop vegetables, toss with olive oil and seasonings, roast in the oven', 30, 'https://lh3.googleusercontent.com/x2feHXYWBaalUV_e1Wh_VBa8w190FtklbgRyb4sFZdXGf68Fp5MzRS792xvE9pMYSTfh5USuFGVkMqYpeRl2U_0=w640-h640-c-rw-v1-e365', 9);

INSERT INTO tb_recipe (name, ingredients, preparation, time, img_Url, author_id) 
VALUES ('Vegetable Curry', 'Mixed vegetables (potatoes, carrots, peas, bell peppers), coconut milk, curry paste', 'Cook vegetables, add curry paste and coconut milk, simmer until tender', 25, 'https://lh3.googleusercontent.com/YPZqx5R4ef0QUjcDelRsAeBYFVD-FgGl9b6G-P7lEiNuZKasqTm-lHdAv2w9_VIPjaIPNs_1K1H-XV3TBJDqRg=w640-h640-c-rw-v1-e365', 7);

INSERT INTO tb_recipe (name, ingredients, preparation, time, img_Url, author_id) 
VALUES ('Tacos', 'Tortillas, ground beef, lettuce, tomato, cheese, salsa', 'Brown beef, warm tortillas, assemble tacos with toppings', 30, 'https://lh3.googleusercontent.com/d3Xjs3NGFSrd7xWn5swWQulJoDTUIdOgPeW2Ce5ASmHXPiZ0p7fsJf26kQOEsL6JE_6lkNO7h3553ipWlx6KGME=w640-h640-c-rw-v1-e365', 4);

INSERT INTO tb_recipe (name, ingredients, preparation, time, img_Url, author_id) 
VALUES ('Stir-Fried Noodles', 'Noodles, vegetables, soy sauce, sesame oil', 'Boil noodles, stir-fry with vegetables and sauce', 20, 'https://lh3.googleusercontent.com/oFcXz5z3qnoLqrv9d5sf-OswCbOpaL6ad2StCN-jC_xfZJllpXuo1CyK8swqGuLT6qn5BuMotYOn9oyknLnk_w=w640-h640-c-rw-v1-e365', 2);

INSERT INTO tb_recipe (name, ingredients, preparation, time, img_Url, author_id) 
VALUES ('Greek Salad', 'Cucumbers, tomatoes, red onions, feta cheese, olives, olive oil, lemon juice', 'Chop vegetables and cheese, toss with olive oil and lemon juice', 15, 'https://lh3.googleusercontent.com/7OVghwen1JYng5dXhNW6QnLjKYYLKgp3gKuZkEILLpryaah8XCHlvtaY8d_VVheA1m9bnYGccm0NxnkqOIEYH-I=w640-h640-c-rw-v1-e365', 3);

INSERT INTO tb_recipe_favorited (recipe_id, user_id) VALUES (1, 2);
INSERT INTO tb_recipe_favorited (recipe_id, user_id) VALUES (2, 3);
INSERT INTO tb_recipe_favorited (recipe_id, user_id) VALUES (3, 4);
INSERT INTO tb_recipe_favorited (recipe_id, user_id) VALUES (1, 5);
INSERT INTO tb_recipe_favorited (recipe_id, user_id) VALUES (1, 6);
INSERT INTO tb_recipe_favorited (recipe_id, user_id) VALUES (2, 7);
INSERT INTO tb_recipe_favorited (recipe_id, user_id) VALUES (5, 2);
INSERT INTO tb_recipe_favorited (recipe_id, user_id) VALUES (6, 3);
INSERT INTO tb_recipe_favorited (recipe_id, user_id) VALUES (7, 4);
INSERT INTO tb_recipe_favorited (recipe_id, user_id) VALUES (5, 5);
INSERT INTO tb_recipe_favorited (recipe_id, user_id) VALUES (6, 6);
INSERT INTO tb_recipe_favorited (recipe_id, user_id) VALUES (10, 7);
INSERT INTO tb_recipe_favorited (recipe_id, user_id) VALUES (8, 8);
INSERT INTO tb_recipe_favorited (recipe_id, user_id) VALUES (9, 9);
INSERT INTO tb_recipe_favorited (recipe_id, user_id) VALUES (9, 10);
INSERT INTO tb_recipe_favorited (recipe_id, user_id) VALUES (10, 1);

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
VALUES ('Too sweet', 1, TIMESTAMP WITH TIME ZONE '2023-07-09T21:30:15', 5, 3);

INSERT INTO tb_feedback (comment, pontuation, moment, recipe_id, user_id) 
VALUES ('Fresh and delicious', 4, TIMESTAMP WITH TIME ZONE '2023-07-09T14:30:00', 6, 1);

INSERT INTO tb_feedback (comment, pontuation, moment, recipe_id, user_id) 
VALUES ('Needs more dressing', 3, TIMESTAMP WITH TIME ZONE '2023-07-09T16:45:10', 7, 3);

INSERT INTO tb_feedback (comment, pontuation, moment, recipe_id, user_id) 
VALUES ('Perfectly grilled', 5, TIMESTAMP WITH TIME ZONE '2023-07-09T17:11:25', 8, 15);

INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (1, 4);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (1, 1);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (2, 1);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (3, 1);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (3, 4);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (4, 7);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (5, 5);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (5, 8);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (5, 9);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (5, 10);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (6, 1);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (6, 5);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (6, 9);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (7, 5);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (7, 8);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (7, 9);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (7, 10);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (8, 5);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (8, 8);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (8, 9);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (8, 10);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (9, 2);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (9, 12);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (10, 2);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (10, 13);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (11, 5);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (11, 8);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (11, 9);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (11, 10);
INSERT INTO tb_recipe_category (recipe_id, category_id) VALUES (11, 14);
