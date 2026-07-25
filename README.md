# Page Pulse

Page Pulse is a full-stack web application that audits any public website and generates a quick report containing SEO, accessibility, and performance-related information.

Live Demo: https://page-pulse-tan-ten.vercel.app

---

## Features

- Audit any publicly accessible website
- Measure HTTP status code
- Measure response time
- Extract page title
- Extract meta description
- Count H1 headings
- Detect images missing alt attributes
- Calculate page word count
- User-friendly error handling
- Responsive UI
- RESTful API built with Spring Boot

---

## Tech Stack

### Frontend
- React
- Vite
- Tailwind CSS
- Axios

### Backend
- Java 21
- Spring Boot
- Jsoup
- Maven

### Deployment
- Frontend: Vercel
- Backend: Render

---

## Project Structure

```
Page_Pulse_Application/
│
├── frontend/
│   ├── src/
│   ├── public/
│   └── package.json
│
├── backend/
│   └── page-pulse/
│       └── page-pulse/
│           ├── src/
│           ├── pom.xml
│           └── Dockerfile
│
└── README.md
```

---

## API Endpoint

### Audit Website

**POST**

```
/api/v1/audit
```

### Request

```json
{
  "url": "https://openai.com"
}
```

### Success Response

```json
{
  "success": true,
  "data": {
    "url": "https://openai.com",
    "httpStatus": 200,
    "responseTimeMs": 327,
    "pageTitle": "OpenAI | Research & Deployment",
    "metaDescription": "...",
    "h1Count": 0,
    "imagesMissingAlt": 0,
    "wordCount": 466
  }
}
```

---

## Running Locally

### Clone Repository

```bash
git clone https://github.com/Prateek195jain/page-pulse.git
```

### Backend

```bash
cd backend/page-pulse/page-pulse

./mvnw spring-boot:run
```

Backend runs on:

```
http://localhost:8080
```

### Frontend

```bash
cd frontend

npm install
npm run dev
```

Frontend runs on:

```
http://localhost:5173
```

---

## Testing

Unit tests have been written for:

- HTML parsing logic

Run tests using:

```bash
./mvnw test
```

---

## Error Handling

The API handles common error scenarios including:

- Invalid URL
- Missing URL
- Connection failures
- Website timeout
- Unexpected server errors

---

## Future Improvements

- Lighthouse integration
- SEO scoring
- Accessibility scoring
- PDF report generation
- Export audit reports
- Audit history
- Authentication

---

## Author

Prateek Jain

GitHub:
https://github.com/Prateek195jain
