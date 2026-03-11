# Static Analysis Demo Project

This project demonstrates various code quality issues that can be detected by static analysis tools.

## Project Structure

```
src/main/java/com/example/
├── BankingApp.java    - Contains various security and quality issues
└── DataProcessor.java - Contains performance and design issues
```

## Static Analysis Tools

This project uses:
1. **GitHub CodeQL** - Advanced semantic code analysis
2. **SpotBugs** - Bug detection for Java
3. **PMD** - Code quality analysis

## Running Static Analysis

### SpotBugs
```bash
mvn spotbugs:check
```

### PMD
```bash
mvn pmd:check
```

## Code Issues Demonstrated

### Security Issues
- SQL injection vulnerability
- Hardcoded credentials
- Resource leaks

### Code Quality Issues
- Null pointer dereference potential
- Inefficient string concatenation
- Unused variables and imports
- Magic numbers
- Empty catch blocks

### Performance Issues
- Inefficient loops
- Potential deadlocks
- Integer overflow potential

### Design Issues
- Missing equals/hashCode
- Comparison using == instead of equals()
- Methods that always return true/false
