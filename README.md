# 📚 Online Library Management System  

An **Online Library Management System** built using **Jakarta EE**, **JSP**, **CSS**, and **JavaScript** (**Bootstrap & jQuery**) with **MySQL** as the database.  
This system enables admins to manage books and student records while providing students with a dashboard to search, borrow, and return books.  

## 🌟 Features  

### **Admin Dashboard**  
✔ Add, update, and delete books 📖  
✔ Manage student records 👨‍🎓  
✔ View borrowed books and due dates 📅  

### **Student Dashboard**  
✔ Search for available books 🔍  
✔ Borrow and return books ✅  
✔ View borrowing history 📜  

### **Authentication & Security**  
✔ Secure login system for admin and students 🔐  
✔ Session-based authentication 🚀  

### **User Interface**  
✔ Responsive UI using Bootstrap 🎨 

---

## 🛠 Tech Stack  

| Technology       | Description                              |
|-----------------|------------------------------------------|
| **Jakarta EE**  | Enterprise Java for backend development |
| **JSP & Servlets** | Dynamic content rendering             |
| **MySQL**       | Database for storing books & student info |
| **Bootstrap**   | Responsive UI design                    |
| **jQuery & AJAX** | Improved user experience             |

---

## 🚀 Installation & Setup  

### **Prerequisites**  
Before running this project, ensure you have the following installed:  
- **Java JDK 1.8**  
- **GlassFish 6.0**  
- **MySQL Server**  
- **Maven** (for dependency management)  

### **Step 1: Clone the Repository**  
```sh
git clone https://github.com/your-username/library-management-system.git
cd library-management-system

### **Step 2: Set Up the Database**  
1. Create a database in MySQL:  
   ```sql
   CREATE DATABASE library_db;

2. Configure database connection in db-config.properties
   db.url=jdbc:mysql://localhost:3306/library_db
   db.username=root
   db.password=yourpassword

### **Step 3: Deploy on GlassFish 6.0
1. Build the project using Maven:
   mvn clean package

2. Deploy the generated .war file to GlassFish:
   glassfish6/bin/asadmin deploy target/library-management-system.war

3. Start GlassFish and access the system at:
   http://localhost:8080/library-management
```


## 🤝 Contributing
Contributions are welcome! Feel free to fork this repo and submit a pull request with enhancements.
