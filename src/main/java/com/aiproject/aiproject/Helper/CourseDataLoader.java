package com.aiproject.aiproject.Helper;

import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CourseDataLoader {

    @Autowired
    private VectorStore vectorStore;

    public void saveDataInDb() {

        List<Document> documents = List.of(

                new Document(
                        "Java course covering OOP, collections, backend development and multithreading.",
                        Map.of("courseId", "C001", "courseName", "Java Programming Basics", "instructor", "Amit Sharma", "category", "Java")
                ),

                new Document(
                        "Advanced Java course covering multithreading, concurrency, synchronization, and performance optimization.",
                        Map.of("courseId", "C002", "courseName", "Java Multithreading Mastery", "instructor", "Rahul Verma", "category", "Java")
                ),

                new Document(
                        "Spring Boot course covering REST APIs, dependency injection, JPA, and microservices backend development.",
                        Map.of("courseId", "C003", "courseName", "Spring Boot Backend Development", "instructor", "Neha Singh", "category", "Java")
                ),

                new Document(
                        "Java data structures course covering arrays, linked lists, stacks, queues, trees, and graphs.",
                        Map.of("courseId", "C004", "courseName", "Data Structures in Java", "instructor", "Saurabh Jain", "category", "DSA")
                ),

                new Document(
                        "System design course covering scalability, load balancing, caching, and distributed systems.",
                        Map.of("courseId", "C005", "courseName", "System Design Fundamentals", "instructor", "Ankit Gupta", "category", "System Design")
                ),

                new Document(
                        "Python programming course covering basics, loops, functions, and scripting for beginners.",
                        Map.of("courseId", "C006", "courseName", "Python for Beginners", "instructor", "Priya Mehta", "category", "Python")
                ),

                new Document(
                        "Machine learning course covering regression, classification, supervised learning, and model evaluation.",
                        Map.of("courseId", "C007", "courseName", "Machine Learning Basics", "instructor", "Rohit Agarwal", "category", "AI")
                ),

                new Document(
                        "Deep learning course covering neural networks, CNNs, and TensorFlow model training.",
                        Map.of("courseId", "C008", "courseName", "Deep Learning with TensorFlow", "instructor", "Sneha Kapoor", "category", "AI")
                ),

                new Document(
                        "React JS course covering components, hooks, state management, and frontend development.",
                        Map.of("courseId", "C009", "courseName", "React JS Complete Guide", "instructor", "Karan Malhotra", "category", "Frontend")
                ),

                new Document(
                        "Node.js backend course covering Express, REST APIs, authentication, and database integration.",
                        Map.of("courseId", "C010", "courseName", "Node.js Backend Development", "instructor", "Vikas Yadav", "category", "Backend")
                ),

                new Document(
                        "Digital marketing course covering SEO, social media marketing, and online branding.",
                        Map.of("courseId", "C011", "courseName", "Digital Marketing Mastery", "instructor", "Anjali Verma", "category", "Marketing")
                ),

                new Document(
                        "UI UX design course covering wireframing, prototyping, and user-centered design principles.",
                        Map.of("courseId", "C012", "courseName", "UI UX Design Fundamentals", "instructor", "Riya Kapoor", "category", "Design")
                ),

                new Document(
                        "Graphic design course covering Photoshop, Illustrator, and visual design principles.",
                        Map.of("courseId", "C013", "courseName", "Graphic Design Masterclass", "instructor", "Arjun Mehta", "category", "Design")
                ),

                new Document(
                        "Business analytics course covering Excel, SQL, and Power BI for data analysis.",
                        Map.of("courseId", "C014", "courseName", "Business Analytics", "instructor", "Nisha Gupta", "category", "Business")
                ),

                new Document(
                        "Finance course covering budgeting, investments, and personal finance management.",
                        Map.of("courseId", "C015", "courseName", "Finance for Beginners", "instructor", "Rajesh Khanna", "category", "Finance")
                ),

                new Document(
                        "Docker and Kubernetes course covering containerization, orchestration, and deployment.",
                        Map.of("courseId", "C016", "courseName", "Docker and Kubernetes", "instructor", "Aman Tiwari", "category", "DevOps")
                ),

                new Document(
                        "AWS cloud course covering EC2, S3, Lambda, and cloud architecture design.",
                        Map.of("courseId", "C017", "courseName", "AWS Cloud Practitioner", "instructor", "Deepak Sharma", "category", "Cloud")
                ),

                new Document(
                        "Cyber security course covering ethical hacking, encryption, and network security.",
                        Map.of("courseId", "C018", "courseName", "Cyber Security Fundamentals", "instructor", "Kunal Singh", "category", "Security")
                ),

                new Document(
                        "Blockchain course covering smart contracts, decentralized apps, and distributed ledger technology.",
                        Map.of("courseId", "C019", "courseName", "Blockchain Development", "instructor", "Vivek Arora", "category", "Blockchain")
                ),

                new Document(
                        "Android development course covering mobile app development using Java and Kotlin.",
                        Map.of("courseId", "C020", "courseName", "Android App Development", "instructor", "Pooja Sharma", "category", "Mobile")
                ),

                new Document(
                        "SQL and database course covering queries, joins, indexing, and database design.",
                        Map.of("courseId", "C021", "courseName", "SQL and Database Design", "instructor", "Ravi Kumar", "category", "Database")
                ),

                new Document(
                        "Competitive programming course covering algorithms, recursion, and dynamic programming.",
                        Map.of("courseId", "C022", "courseName", "Competitive Programming", "instructor", "Aditya Singh", "category", "DSA")
                ),

                new Document(
                        "Soft skills course covering communication, leadership, and personality development.",
                        Map.of("courseId", "C023", "courseName", "Soft Skills Training", "instructor", "Meena Kapoor", "category", "Personality")
                ),

                new Document(
                        "Interview preparation course covering coding, system design, and HR interview questions.",
                        Map.of("courseId", "C024", "courseName", "Tech Interview Preparation", "instructor", "Sandeep Jain", "category", "Career")
                ),

                new Document(
                        "AI course covering large language models, prompt engineering, embeddings, and AI applications.",
                        Map.of("courseId", "C025", "courseName", "AI with LLMs", "instructor", "Mitesh Tiwari", "category", "AI")
                )
        );

        vectorStore.add(documents); // 🔥 embeddings auto-generated

    }
}