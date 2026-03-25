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
                        """
                        Course Name: Java Programming Basics
                        Instructor: Amit Sharma
                        Category: Java
                        Description: Java course covering OOP, collections, backend development and multithreading.
                        """,
                        Map.of("courseId", "C001", "courseName", "Java Programming Basics", "instructor", "Amit Sharma", "category", "Java")
                ),

                new Document(
                        """
                        Course Name: Java Multithreading Mastery
                        Instructor: Rahul Verma
                        Category: Java
                        Description: Advanced Java course covering multithreading, concurrency, synchronization, and performance optimization.
                        """,
                        Map.of("courseId", "C002", "courseName", "Java Multithreading Mastery", "instructor", "Rahul Verma", "category", "Java")
                ),

                new Document(
                        """
                        Course Name: Spring Boot Backend Development
                        Instructor: Neha Singh
                        Category: Java
                        Description: Spring Boot course covering REST APIs, dependency injection, JPA, and microservices backend development.
                        """,
                        Map.of("courseId", "C003", "courseName", "Spring Boot Backend Development", "instructor", "Neha Singh", "category", "Java")
                ),

                new Document(
                        """
                        Course Name: Data Structures in Java
                        Instructor: Saurabh Jain
                        Category: DSA
                        Description: Java data structures course covering arrays, linked lists, stacks, queues, trees, and graphs.
                        """,
                        Map.of("courseId", "C004", "courseName", "Data Structures in Java", "instructor", "Saurabh Jain", "category", "DSA")
                ),

                new Document(
                        """
                        Course Name: System Design Fundamentals
                        Instructor: Ankit Gupta
                        Category: System Design
                        Description: System design course covering scalability, load balancing, caching, and distributed systems.
                        """,
                        Map.of("courseId", "C005", "courseName", "System Design Fundamentals", "instructor", "Ankit Gupta", "category", "System Design")
                ),

                new Document(
                        """
                        Course Name: Python for Beginners
                        Instructor: Priya Mehta
                        Category: Python
                        Description: Python programming course covering basics, loops, functions, and scripting for beginners.
                        """,
                        Map.of("courseId", "C006", "courseName", "Python for Beginners", "instructor", "Priya Mehta", "category", "Python")
                ),

                new Document(
                        """
                        Course Name: Machine Learning Basics
                        Instructor: Rohit Agarwal
                        Category: AI
                        Description: Machine learning course covering regression, classification, supervised learning, and model evaluation.
                        """,
                        Map.of("courseId", "C007", "courseName", "Machine Learning Basics", "instructor", "Rohit Agarwal", "category", "AI")
                ),

                new Document(
                        """
                        Course Name: Deep Learning with TensorFlow
                        Instructor: Sneha Kapoor
                        Category: AI
                        Description: Deep learning course covering neural networks, CNNs, and TensorFlow model training.
                        """,
                        Map.of("courseId", "C008", "courseName", "Deep Learning with TensorFlow", "instructor", "Sneha Kapoor", "category", "AI")
                ),

                new Document(
                        """
                        Course Name: React JS Complete Guide
                        Instructor: Karan Malhotra
                        Category: Frontend
                        Description: React JS course covering components, hooks, state management, and frontend development.
                        """,
                        Map.of("courseId", "C009", "courseName", "React JS Complete Guide", "instructor", "Karan Malhotra", "category", "Frontend")
                ),

                new Document(
                        """
                        Course Name: Node.js Backend Development
                        Instructor: Vikas Yadav
                        Category: Backend
                        Description: Node.js backend course covering Express, REST APIs, authentication, and database integration.
                        """,
                        Map.of("courseId", "C010", "courseName", "Node.js Backend Development", "instructor", "Vikas Yadav", "category", "Backend")
                ),

                new Document(
                        """
                        Course Name: Digital Marketing Mastery
                        Instructor: Anjali Verma
                        Category: Marketing
                        Description: Digital marketing course covering SEO, social media marketing, and online branding.
                        """,
                        Map.of("courseId", "C011", "courseName", "Digital Marketing Mastery", "instructor", "Anjali Verma", "category", "Marketing")
                ),

                new Document(
                        """
                        Course Name: UI UX Design Fundamentals
                        Instructor: Riya Kapoor
                        Category: Design
                        Description: UI UX design course covering wireframing, prototyping, and user-centered design principles.
                        """,
                        Map.of("courseId", "C012", "courseName", "UI UX Design Fundamentals", "instructor", "Riya Kapoor", "category", "Design")
                ),

                new Document(
                        """
                        Course Name: Graphic Design Masterclass
                        Instructor: Arjun Mehta
                        Category: Design
                        Description: Graphic design course covering Photoshop, Illustrator, and visual design principles.
                        """,
                        Map.of("courseId", "C013", "courseName", "Graphic Design Masterclass", "instructor", "Arjun Mehta", "category", "Design")
                ),

                new Document(
                        """
                        Course Name: Business Analytics
                        Instructor: Nisha Gupta
                        Category: Business
                        Description: Business analytics course covering Excel, SQL, and Power BI for data analysis.
                        """,
                        Map.of("courseId", "C014", "courseName", "Business Analytics", "instructor", "Nisha Gupta", "category", "Business")
                ),

                new Document(
                        """
                        Course Name: Finance for Beginners
                        Instructor: Rajesh Khanna
                        Category: Finance
                        Description: Finance course covering budgeting, investments, and personal finance management.
                        """,
                        Map.of("courseId", "C015", "courseName", "Finance for Beginners", "instructor", "Rajesh Khanna", "category", "Finance")
                ),
                new Document(
                        """
                        Course Name: Finance for intermediate
                        Instructor: Mitesh tiwari
                        Category: Finance
                        Description: Finance course covering budgeting, investments, and personal finance management. very good
                        """,
                        Map.of("courseId", "C015", "courseName", "Finance for Intermediate", "instructor", "Mitesh tiwari", "category", "Finance")
                ),
                new Document(
                        """
                        Course Name: Personal Finance Mastery
                        Instructor: Mitesh Tiwari
                        Category: Finance
                        Description: Learn budgeting, saving, expense tracking, and financial planning for individuals.
                        """,
                        Map.of("courseId", "C026", "courseName", "Personal Finance Mastery", "instructor", "Mitesh Tiwari", "category", "Finance")
                ),

                new Document(
                        """
                        Course Name: Investment Strategies
                        Instructor: Mitesh Tiwari
                        Category: Finance
                        Description: Learn stock market basics, mutual funds, risk management, and long-term investment strategies.
                        """,
                        Map.of("courseId", "C027", "courseName", "Investment Strategies", "instructor", "Mitesh Tiwari", "category", "Finance")
                ),

                new Document(
                        """
                        Course Name: Stock Market Fundamentals
                        Instructor: Mitesh Tiwari
                        Category: Finance
                        Description: Understand stock exchanges, trading basics, technical analysis, and portfolio building.
                        """,
                        Map.of("courseId", "C028", "courseName", "Stock Market Fundamentals", "instructor", "Mitesh Tiwari", "category", "Finance")
                ),

                new Document(
                        """
                        Course Name: Financial Planning and Wealth Management
                        Instructor: Mitesh Tiwari
                        Category: Finance
                        Description: Learn wealth creation, retirement planning, tax saving strategies, and financial goal setting.
                        """,
                        Map.of("courseId", "C029", "courseName", "Financial Planning and Wealth Management", "instructor", "Mitesh Tiwari", "category", "Finance")
                ),

                new Document(
                        """
                        Course Name: Cryptocurrency and Digital Assets
                        Instructor: Mitesh Tiwari
                        Category: Finance
                        Description: Learn about cryptocurrency, blockchain basics, trading strategies, and digital asset management.
                        """,
                        Map.of("courseId", "C030", "courseName", "Cryptocurrency and Digital Assets", "instructor", "Mitesh Tiwari", "category", "Finance")
                ),
                new Document(
                        """
                        Course Name: Personal Finance Mastery
                        Instructor: Mitesh Tiwari
                        Category: Finance
                        Description: Learn budgeting, saving, expense tracking, and financial planning for individuals.
                        """,
                        Map.of("courseId", "C026", "courseName", "Personal Finance Mastery", "instructor", "Mitesh Tiwari", "category", "Finance")
                ),

                new Document(
                        """
                        Course Name: Investment Strategies
                        Instructor: Mitesh Tiwari
                        Category: Finance
                        Description: Learn stock market basics, mutual funds, risk management, and long-term investment strategies.
                        """,
                        Map.of("courseId", "C027", "courseName", "Investment Strategies", "instructor", "Mitesh Tiwari", "category", "Finance")
                ),

                new Document(
                        """
                        Course Name: Stock Market Fundamentals
                        Instructor: Mitesh Tiwari
                        Category: Finance
                        Description: Understand stock exchanges, trading basics, technical analysis, and portfolio building.
                        """,
                        Map.of("courseId", "C028", "courseName", "Stock Market Fundamentals", "instructor", "Mitesh Tiwari", "category", "Finance")
                ),

                new Document(
                        """
                        Course Name: Financial Planning and Wealth Management
                        Instructor: Mitesh Tiwari
                        Category: Finance
                        Description: Learn wealth creation, retirement planning, tax saving strategies, and financial goal setting.
                        """,
                        Map.of("courseId", "C029", "courseName", "Financial Planning and Wealth Management", "instructor", "Mitesh Tiwari", "category", "Finance")
                ),
                new Document(
                        """
                        Course Name: Full Stack Web Development
                        Instructor: Mitesh Tiwari
                        Category: Web Development
                        Description: Learn frontend and backend development using React, Node.js, and databases.
                        """,
                        Map.of("courseId", "C031", "courseName", "Full Stack Web Development", "instructor", "Mitesh Tiwari", "category", "Web Development")
                ),

                new Document(
                        """
                        Course Name: Data Engineering Fundamentals
                        Instructor: Mitesh Tiwari
                        Category: Data Engineering
                        Description: Learn ETL pipelines, data warehousing, and big data processing using modern tools.
                        """,
                        Map.of("courseId", "C032", "courseName", "Data Engineering Fundamentals", "instructor", "Mitesh Tiwari", "category", "Data Engineering")
                ),

                new Document(
                        """
                        Course Name: DevOps Essentials
                        Instructor: Mitesh Tiwari
                        Category: DevOps
                        Description: Learn CI/CD pipelines, Docker, Kubernetes, and cloud deployment strategies.
                        """,
                        Map.of("courseId", "C033", "courseName", "DevOps Essentials", "instructor", "Mitesh Tiwari", "category", "DevOps")
                ),

                new Document(
                        """
                        Course Name: System Design Advanced
                        Instructor: Mitesh Tiwari
                        Category: System Design
                        Description: Learn scalable architecture, distributed systems, and real-world system design patterns.
                        """,
                        Map.of("courseId", "C034", "courseName", "System Design Advanced", "instructor", "Mitesh Tiwari", "category", "System Design")
                ),

                new Document(
                        """
                        Course Name: Startup and Product Building
                        Instructor: Mitesh Tiwari
                        Category: Business
                        Description: Learn how to build, launch, and scale a startup with product-market fit strategies.
                        """,
                        Map.of("courseId", "C035", "courseName", "Startup and Product Building", "instructor", "Mitesh Tiwari", "category", "Business")
                ),
                new Document(
                        """
                        Course Name: Cryptocurrency and Digital Assets
                        Instructor: Mitesh Tiwari
                        Category: Finance
                        Description: Learn about cryptocurrency, blockchain basics, trading strategies, and digital asset management.
                        """,
                        Map.of("courseId", "C030", "courseName", "Cryptocurrency and Digital Assets", "instructor", "Mitesh Tiwari", "category", "Finance")
                ),

                new Document(
                        """
                        Course Name: Docker and Kubernetes
                        Instructor: Aman Tiwari
                        Category: DevOps
                        Description: Docker and Kubernetes course covering containerization, orchestration, and deployment.
                        """,
                        Map.of("courseId", "C016", "courseName", "Docker and Kubernetes", "instructor", "Aman Tiwari", "category", "DevOps")
                ),

                new Document(
                        """
                        Course Name: AWS Cloud Practitioner
                        Instructor: Deepak Sharma
                        Category: Cloud
                        Description: AWS cloud course covering EC2, S3, Lambda, and cloud architecture design.
                        """,
                        Map.of("courseId", "C017", "courseName", "AWS Cloud Practitioner", "instructor", "Deepak Sharma", "category", "Cloud")
                ),

                new Document(
                        """
                        Course Name: Cyber Security Fundamentals
                        Instructor: Kunal Singh
                        Category: Security
                        Description: Cyber security course covering ethical hacking, encryption, and network security.
                        """,
                        Map.of("courseId", "C018", "courseName", "Cyber Security Fundamentals", "instructor", "Kunal Singh", "category", "Security")
                ),

                new Document(
                        """
                        Course Name: Blockchain Development
                        Instructor: Vivek Arora
                        Category: Blockchain
                        Description: Blockchain course covering smart contracts, decentralized apps, and distributed ledger technology.
                        """,
                        Map.of("courseId", "C019", "courseName", "Blockchain Development", "instructor", "Vivek Arora", "category", "Blockchain")
                ),

                new Document(
                        """
                        Course Name: Android App Development
                        Instructor: Pooja Sharma
                        Category: Mobile
                        Description: Android development course covering mobile app development using Java and Kotlin.
                        """,
                        Map.of("courseId", "C020", "courseName", "Android App Development", "instructor", "Pooja Sharma", "category", "Mobile")
                ),

                new Document(
                        """
                        Course Name: SQL and Database Design
                        Instructor: Ravi Kumar
                        Category: Database
                        Description: SQL and database course covering queries, joins, indexing, and database design.
                        """,
                        Map.of("courseId", "C021", "courseName", "SQL and Database Design", "instructor", "Ravi Kumar", "category", "Database")
                ),

                new Document(
                        """
                        Course Name: Competitive Programming
                        Instructor: Aditya Singh
                        Category: DSA
                        Description: Competitive programming course covering algorithms, recursion, and dynamic programming.
                        """,
                        Map.of("courseId", "C022", "courseName", "Competitive Programming", "instructor", "Aditya Singh", "category", "DSA")
                ),

                new Document(
                        """
                        Course Name: Soft Skills Training
                        Instructor: Meena Kapoor
                        Category: Personality
                        Description: Soft skills course covering communication, leadership, and personality development.
                        """,
                        Map.of("courseId", "C023", "courseName", "Soft Skills Training", "instructor", "Meena Kapoor", "category", "Personality")
                ),

                new Document(
                        """
                        Course Name: Tech Interview Preparation
                        Instructor: Sandeep Jain
                        Category: Career
                        Description: Interview preparation course covering coding, system design, and HR interview questions.
                        """,
                        Map.of("courseId", "C024", "courseName", "Tech Interview Preparation", "instructor", "Sandeep Jain", "category", "Career")
                ),

                new Document(
                        """
                        Course Name: AI with LLMs
                        Instructor: Mitesh Tiwari
                        Category: AI
                        Description: AI course covering large language models, prompt engineering, embeddings, and AI applications.
                        """,
                        Map.of("courseId", "C025", "courseName", "AI with LLMs", "instructor", "Mitesh Tiwari", "category", "AI")
                )
        );

        vectorStore.add(documents); // 🔥 embeddings auto-generated

    }
}