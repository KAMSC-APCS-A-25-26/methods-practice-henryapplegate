#!/bin/bash
# Methods Practice Setup Script
echo "Setting up Methods Practice Assignment..."

# Make sure we're in the right directory
if [ ! -f "pom.xml" ]; then
    echo "❌ Error: pom.xml not found. Make sure you're in the MethodsPractice directory."
    exit 1
fi

# Compile the project
echo "📦 Compiling project..."
mvn clean compile

if [ $? -eq 0 ]; then
    echo "✅ Compilation successful!"
else
    echo "❌ Compilation failed. Please check your code."
    exit 1
fi

# Run tests
echo "🧪 Running tests..."
mvn test

if [ $? -eq 0 ]; then
    echo "✅ All tests passed!"
else
    echo "❌ Some tests failed. Check the output above for details."
fi

echo "Setup complete! 🎉"
