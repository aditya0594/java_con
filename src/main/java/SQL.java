public class SQL {

/**
 Select * from products;

 SELECT productId,stock,name from products WHERE stock = '2';

 SELECt productId,name,categoryId,stock FROM products WHERE categoryId='2' AND stock ='2';

 SELECT productId,name,price FROM products WHERE price BETWEEN '3' AND '10';

 SELECT productId,name,price FROM products WHERE productId = '2' AND price BETWEEN '3' AND '10';

 SELECT productId,name FROM products WHERE NOT productId='2';

 SELECT productId,description,name from products WHERE description='Women Tee hip hip';

 SELECT productId,price,Count(*) from products GROUP BY price HAVING price BETWEEN '5' AND '6';

 SELECT * from products Where price=(SELECT max(price) from products);

 SELECT price from products ORDER BY price DESC LIMIT 1;


 UPDATE products set price =80 where productId=1;
 Insert into cart (userID, productId) values(1,2);

 select * from products where productId=(select productId from cart where userId)=(select userID from users where country='Canada');
 Select * from products;
 Select * from cart;
 Select * from users;

 SELECt * FROM products INNER JOIN cart ON cart.productId = products.productId;







 */



}
