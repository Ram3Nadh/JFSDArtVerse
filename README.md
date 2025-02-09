Please follow the instructions to run this project.
 step 1) update application.properites( give your mysql database name and password of that), give some port number which is not in use.

 step 2) run as spring boot app.

 step 3) update your mail and pass(Create a app pass) and use them.

 these two steps are enough to run the application on your local device.

 Now we will see some features of this project- 
 there are two modules in this project 
 1. admin.
 2. user.



Project Highlights:


Enhanced Security -
The project prioritizes security by implementing robust encryption for passwords, ensuring secure storage in the database.

Comprehensive Email Services -
Users receive timely email notifications, including order confirmation upon placing an order and updates on order status changes. Additionally, a secure token-based system is in place for password reset functionality.

Efficient Session Management -
To enhance security, users are automatically logged out after 90 seconds of inactivity, protecting sensitive information and ensuring secure access.

VR Model Integration -
The project features an integrated VR model, offering users an immersive experience that elevates engagement and interactivity.

Optimized User Experience -
Designed with user-friendliness in mind, the project ensures smooth and intuitive interactions, providing a seamless and enjoyable experience for all users.

Admin module execution - 

1)First User should register.
![image](https://github.com/user-attachments/assets/bb99b958-a2e8-45a8-9219-4da1d637a440)

2) click on Register Button and fill the data .

    please fill data carefully, validation is used on those fields.

3) open you mysql user_dtls see all the details.
   ![image](https://github.com/user-attachments/assets/73b9c0a7-0ccd-43ea-94ec-2aa8c121fc3c)
   Change role from ROLE_USER to ROLE_ADMIN then you can login as admin.
   use the same credentials for login as admin.

4) admin dashboard -
   ![image](https://github.com/user-attachments/assets/b30e489a-c815-4f21-836c-1d69283278fc)

5) add category -
   ![image](https://github.com/user-attachments/assets/ad6da7ae-68b4-477b-adef-a6130da24036)

6) add art -
   ![image](https://github.com/user-attachments/assets/1b32ab9b-a172-409a-a9e4-c6f84da880e5)

7) View all arts -
   ![image](https://github.com/user-attachments/assets/261fb825-2934-4632-8c64-f7906c0ec884)

8) View all Orders -
   ![image](https://github.com/user-attachments/assets/faaf0b7b-0ead-4939-8e30-6e141a19b07d)
   we can update the status of order, user will get order status after updating.

9) View all users -
    ![image](https://github.com/user-attachments/assets/199b6b5f-afb3-4e8c-aee6-5a65f139925e)
   we can make users inactive so that thay can't login with that credentials.

10) View all admins -
    ![image](https://github.com/user-attachments/assets/9ee50f3c-6d16-4b91-81d4-da2e4028200f)
     we can make admin inactive so that thay can't login with that credentials.

11) add admin -
    ![image](https://github.com/user-attachments/assets/b1498113-9cbd-4a46-9817-278c39d54c86)

12) edit profile -
    ![image](https://github.com/user-attachments/assets/2cf693ec-341f-4e5e-8a70-90bcb0536334)


User Module -
1) User should Register and use them for login.
   ![image](https://github.com/user-attachments/assets/3ed51a60-868f-46f7-a179-213d5330f64e)

   ![image](https://github.com/user-attachments/assets/47cacaf5-1d4e-4e2c-bfb9-cb1cfee92201)

2) user dashboard will be visible.
   ![image](https://github.com/user-attachments/assets/577bb4a2-9cd7-4486-ade4-26fa9c3e01b6)

3) Artworks -
   ![image](https://github.com/user-attachments/assets/a3605429-1c2d-4c6e-911d-3d21362ff934)

   we can sort arts according to different categories.

4) Veiw art -
   ![image](https://github.com/user-attachments/assets/c3d55975-197e-42ae-ad3b-69657ff75679)
   add to cart.

5) View Cart -
   ![image](https://github.com/user-attachments/assets/8b721c04-fcd4-40ac-88d6-fd21445da9c2)

   click proceed to payment.

6) Payment Gateway -
   ![image](https://github.com/user-attachments/assets/c822acdc-1058-4d16-a3e9-331e1ec9475c)
   fill all the data and place order
   ![image](https://github.com/user-attachments/assets/8a792c76-838f-4651-9b5e-8d056b5888fe)

   you will recieve a confirmation mail.






















