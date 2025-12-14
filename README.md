# InstaClone

Full-stack Instagram clone with **Spring Boot** backend and **React.js** frontend.

---

🚀 **Features**

* **Authentication:** JWT-based signup/login (username or email)
* **Posts:** Create, view, like, and comment on posts
* **Social:** Follow/unfollow users, view profiles
* **Feed:** Home feed with posts from followed users
* **Responsive UI:** Clean React.js frontend

---

🛠️ **Tech Stack**

**Backend**

* Java 21
* Spring Boot 3.4.2
* Spring Security + JWT
* Spring Data JPA
* MySQL 8.0
* Lombok

**Frontend**

* React.js 18
* Axios
* CSS

---

📋 **Prerequisites**

* JDK 21 or higher
* Maven 3.9+
* MySQL 8.0
* Node.js 18+ and npm

---

⚙️ **Setup**

**Backend Setup**

1. Clone the repository:

```bash
git clone <your-repo-url>
cd Instagram-Clone-Sami
```

2. Configure database:

```sql
CREATE DATABASE insta_clone;
```

3. Copy `src/main/resources/application.properties.example` to `application.properties`
4. Update database credentials in `application.properties`:

```properties
spring.datasource.username=your_username
spring.datasource.password=your_password
```

5. Run the backend:

```bash
./mvnw spring-boot:run
```

Backend will start on [http://localhost:2121](http://localhost:2121)

**Frontend Setup**

1. Navigate to frontend folder and install dependencies:

```bash
cd frontend
npm install
```

2. Run the dev server:

```bash
npm start
```

Frontend will start on [http://localhost:3000](http://localhost:3000)

---

📱 **Application Structure**

**Backend Endpoints**

**Authentication (/auth)**

* `POST /auth/signup` - Create new account
* `POST /auth/login` - Login (returns JWT token)

**Posts (/api/posts)**

* `GET /api/posts` - Get all posts
* `GET /api/posts/{id}` - Get single post
* `POST /api/posts` - Create post (requires auth)
* `POST /api/posts/{id}/like` - Like a post
* `POST /api/posts/{id}/unlike` - Unlike a post
* `POST /api/posts/{id}/comments` - Add comment

**Users (/api/users)**

* `GET /api/users/{username}` - Get user profile
* `POST /api/users/{username}/follow` - Follow user
* `POST /api/users/{username}/unfollow` - Unfollow user

**Frontend Pages**

* `/` - Home feed
* `/login` - Login page
* `/signup` - Signup page
* `/create-post` - Create new post
* `/profile/[username]` - User profile
* `/post/[id]` - Post detail view

---

🔐 **Security**

* CORS enabled for local development (ports 3000, 3001)
* JWT authentication with Bearer token
* Password encryption with BCrypt
* Protected API endpoints require authentication

---

📝 **Environment Variables**

**Backend** - Set in `src/main/resources/application.properties`:

```properties
spring.datasource.url
spring.datasource.username
spring.datasource.password
```

**Frontend** - Optional, create `frontend/.env`:

```env
REACT_APP_API_URL=http://localhost:2121
```

---

🤝 **Contributing**
Feel free to submit issues and pull requests!

---

📄 **License**
MIT License
