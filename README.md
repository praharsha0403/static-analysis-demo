# Static Analysis Demo Project

This project demonstrates various code quality issues that can be detected by static analysis tools for the CS 161 Static Analyzers assignment.

## Project Structure

```
├── src/main/java/com/example/
│   ├── BankingApp.java    - Contains various security and quality issues
│   └── DataProcessor.java - Contains performance and design issues
├── .github/workflows/
│   └── codeql.yml         - GitHub Actions workflow for CodeQL scanning
├── pom.xml                - Maven configuration with PMD plugin
├── STATIC_ANALYSIS_REPORT.md - Comprehensive analysis report
└── README.md              - This file
```

## Static Analysis Tools

This project uses:
1. **GitHub CodeQL** - Advanced semantic code analysis (security-focused)
2. **PMD** - Code quality analysis (rule-based static analysis)

## How to Run Static Analysis

### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher
- Git (for CodeQL integration)

### Setup Instructions

1. **Clone and Navigate to Project**:
   ```bash
   cd "/Users/chaitanyasai/Downloads/Software T... Assignment"
   ```

2. **Compile the Project**:
   ```bash
   mvn clean compile
   ```

### Running PMD Analysis

```bash
# Run PMD check (generates report in target/pmd.xml)
mvn pmd:check

# View PMD report
cat target/pmd.xml

# Generate HTML report (optional)
mvn pmd:pmd
# View HTML report at: target/site/pmd.html
```

### Setting Up CodeQL

1. **Initialize Git Repository** (if not already done):
   ```bash
   git init
   git add .
   git commit -m "Initial commit with static analysis demo"
   ```

2. **Create GitHub Repository**:
   - Go to https://github.com/praharsha0403
   - Create new repository: `static-analysis-demo`
   - Push the code to GitHub

3. **Enable CodeQL**:
   ```bash
   git remote add origin https://github.com/praharsha0403/static-analysis-demo.git
   git branch -M main
   git push -u origin main
   ```

4. **Activate CodeQL in GitHub**:
   - Go to your repository on GitHub
   - Navigate to **Settings** → **Security & analysis** → **Code scanning**
   - Click **Set up code scanning** with CodeQL
   - The workflow in `.github/workflows/codeql.yml` will automatically run

5. **View CodeQL Results**:
   - Go to **Security** → **Code scanning** in your GitHub repository
   - Results will appear after the first workflow run completes

### Alternative: Local CodeQL Analysis

For local CodeQL analysis (requires CodeQL CLI):

```bash
# Install CodeQL CLI (if not already installed)
# Follow instructions at: https://codeql.github.com/docs/codeql-cli/

# Initialize CodeQL database
codeql database create java-database --language=java --source-root=src/main/java

# Run CodeQL analysis
codeql database analyze java-database --format=csv --output=codeql-results.csv

# View results
cat codeql-results.csv
```

## Analysis Results Summary

### PMD Results
- **Total Violations**: 22
- **Critical Issues**: Resource leaks, string comparison bugs
- **Code Quality**: Unused variables, design improvements
- **Best Practices**: String literal positioning, field organization

### CodeQL Results
- **Security Issues**: SQL injection, hardcoded credentials
- **Semantic Issues**: Null pointer potential, data flow problems
- **Logic Errors**: Infinite loops, deadlock potential

## Assignment Requirements Coverage

✅ **Goals and Purposes**: Documented in `STATIC_ANALYSIS_REPORT.md`  
✅ **GitHub CodeQL Enabled**: Configured via GitHub Actions workflow  
✅ **Additional Tool**: PMD integrated via Maven plugin  
✅ **Findings Overview**: Detailed results for both tools provided  
✅ **Detailed Analysis**: Specific warnings analyzed per team member  
✅ **Tool Comparison**: Comprehensive comparison included  

## Key Files for Assignment

- `STATIC_ANALYSIS_REPORT.md` - Complete analysis and comparison
- `target/pmd.xml` - Raw PMD findings
- `.github/workflows/codeql.yml` - CodeQL configuration
- `src/main/java/com/example/` - Code with intentional issues

## Team Member Analysis Examples

### PMD Findings Examples:
1. **Resource Management** - Critical database connection leaks
2. **String Comparison** - Using '==' instead of .equals()
3. **Code Quality** - Unused variables and dead code

### CodeQL Findings Examples:
1. **SQL Injection** - Direct string concatenation in queries
2. **Hardcoded Credentials** - Passwords in source code
3. **Null Pointer Dereference** - Missing null checks

## Troubleshooting

### PMD Issues
- **Maven not found**: Install with `brew install maven`
- **Java version issues**: Ensure Java 11+ is installed and configured
- **Compilation errors**: Check for syntax issues in Java files

### CodeQL Issues
- **Workflow not running**: Check GitHub Actions permissions
- **No results**: Ensure repository is public or has GitHub Advanced Security
- **Analysis failures**: Check Java compilation and dependencies

## Next Steps

1. Push to GitHub to activate CodeQL scanning
2. Review PMD findings in `target/pmd.xml`
3. Read comprehensive analysis in `STATIC_ANALYSIS_REPORT.md`
4. Compare results in GitHub's Code scanning dashboard
