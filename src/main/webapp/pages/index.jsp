<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Learning Logs</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/index.css">
</head>
<body>
    <nav class="navbar">
        <div class="navbar-start">
            <button class="btn btn-square btn-ghost">
                <svg class="icon" viewBox="0 0 24 24">
                    <path d="M4 6h16M4 12h16M4 18h16"></path>
                </svg>
            </button>
        </div>

        <div class="navbar-center">
            <a class="btn btn-ghost text-xl" href="${pageContext.request.contextPath}/pages/index.jsp">Learning Logs</a>
        </div>

        <div class="navbar-end">
            <a class="btn btn-ghost" href="${pageContext.request.contextPath}/pages/topic.jsp">Topics</a>
            <a class="btn btn-ghost" href="${pageContext.request.contextPath}/pages/entry.jsp">Entry</a>
        </div>
    </nav>
    <main class="content">
        <div class="divider-page">
            <section class="hero">
                <h1 class="hero-title">Start your journal adventure</h1>
                <p class="hero-subtitle">Pick a topic to explore or add a new entry to your learning log.</p>
            </section>
            <div class="flex-container">
                <a class="card option-card" href="${pageContext.request.contextPath}/pages/topic.jsp">Topic</a>
                <div class="divider-horizontal">OR</div>
                <a class="card option-card" href="${pageContext.request.contextPath}/pages/entry.jsp">Entry</a>
            </div>
        </div>
    </main>
    <footer class="footer">
        <div class="footer-container">
            <nav class="footer-nav">
                <h6 class="footer-title">Services</h6>
                <a class="footer-link">Branding</a>
                <a class="footer-link">Design</a>
                <a class="footer-link">Marketing</a>
                <a class="footer-link">Advertisement</a>
            </nav>

            <nav class="footer-nav">
                <h6 class="footer-title">Company</h6>
                <a class="footer-link">About us</a>
                <a class="footer-link">Contact</a>
                <a class="footer-link">Jobs</a>
                <a class="footer-link">Press kit</a>
            </nav>

            <nav class="footer-nav">
                <h6 class="footer-title">Legal</h6>
                <a class="footer-link">Terms of use</a>
                <a class="footer-link">Privacy policy</a>
                <a class="footer-link">Cookie policy</a>
            </nav>
        </div>
    </footer>
</body>
</html>

