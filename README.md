# UserVault – Profile Manager

UserVault is a secure **Profile Management Web Application** built using **Spring MVC and JDBC**, providing complete user authentication, session handling, and profile management features with a modern UI.

---

## Features

* User can Signup & Login.
* Secure Password Hashing using **BCrypt** (Spring security).
* Session-based Authentication.
* View, Edit and Delete User Profile.
* Forgot Password & Reset Password Flow using session token.
* Account Deletion with Confirmation.
* Protected Routes using **Servlet Filters**
* Input Validation & Error Handling.
* MVC Architecture with Clean Separation of Layers like - Bean, DAO, Controller, Services, Filter, and Resources.

---

## 🛠️ Tech Stack

* **Backend:** Java, Spring MVC, JDBC
* **Frontend:** JSP, HTML, CSS, JavaScript
* **Database:** MySQL Workbench (JDBC-based)
* **Security:** BCrypt Password Hashing, HttpSession
* **Server:** Apache Tomcat 10.1
* **Build Tool:** Maven

---

## 📂 Project Structure

```
src/main
│
├── java/in/cb
│   ├── bean
│   │   ├── User.java
│   │   └── UserRowMapper.java
│   │
│   ├── dao
│   │   └── UserDao.java
│   │
│   ├── service
│   │   └── UserService.java
│   │
│   ├── filter
│   │   └── AuthFilter.java
│   │
│   ├── main
│   │   └── MyController.java
│   │
│   └── resources
│       ├── JDBCConfigFile.java
│       └── SecurityConfig.java
│
├── webapp
│   ├── css
│   │   ├── auth.css
│   │   ├── edit.css
│   │   ├── home.css
│   │   ├── index.css
│   │   └── style.css
│   │
│   └── WEB-INF
│       ├── views
│       │   ├── login.jsp
│       │   ├── signup.jsp
│       │   ├── home.jsp
│       │   ├── edit.jsp
│       │   ├── forgot.jsp
│       │   ├── reset-password.jsp
│       │   └── index.jsp
│       │
│       ├── ds-servlet.xml
│       └── web.xml
│
├── pom.xml
└── README.md
```

---

## 🔐 Security Highlights

* Passwords are **never stored in plain text**.
* Implemented one way hasing password can not retrived in normal form.
* BCrypt hashing ensures strong password protection
* Servlet Filter (`AuthFilter`) prevents unauthorized access
* Cache-control headers block back-button access after logout
* Reset password flow protected via session-based validation and Token.

---

## 🔄 Application Flow

1. **Signup** → User registers with hashed password
2. **Login** → Credentials validated using BCrypt
3. **Dashboard** → Protected via session & filter
4. **Profile Management** → View / Edit profile details
5. **Forgot Password** → Identity verification
6. **Reset Password** → Secure update
7. **Logout / Delete Account** → Session invalidated

---

## ⚙️ Setup & Run Locally

1. Clone the repository:

   ```bash
   git clone https://github.com/Chetanpatil03/profile-manager.git
   ```

2. Configure database in:

   ```
   JDBCConfigFile.java
   ```

3. Update database credentials:

   ```properties
   jdbc.url=jdbc:mysql://localhost:3306/your_db
   jdbc.username=your_username
   jdbc.password=your_password
   ```

4. Build the project:

   ```bash
   mvn clean install
   ```

5. Deploy on **Apache Tomcat** and access:

   ```
   http://localhost:8080/profile-manager
   ```

---

## 📌 Key Learning Outcomes

* Implemented **Spring MVC architecture**
* Hands-on experience with **JDBC & RowMappers**
* Designed secure authentication flows
* Built reusable UI components using JSP & CSS
* Applied real-world **session management & security**
* Learn about hashing and **BCrypt**.

---

## 🧩 Application Flow Diagram - UserVault

The diagram below illustrates the complete user journey and system flow,
including authentication, profile management, and password recovery.

<img width="11526" height="6693" alt="UserVault-design" src="https://github.com/user-attachments/assets/92f6eff9-e0cb-4aa2-9229-744248fd3e8b" />

---

## 👤 Author

**Chetan Bachchhav**</br>
Java Explorer | Tech Enthusiast
