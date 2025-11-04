#!/bin/bash
# Trip Planner Test Runner
echo "Running Trip Planner tests..."

# Make sure we're in the right directory
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
PROJECT_DIR="${SCRIPT_DIR%/tests}"

cd "$PROJECT_DIR" || exit 1

mvn -q -f "$PROJECT_DIR/pom.xml" -Dtest=TripPlannerTest test && echo "✅ Trip Planner tests passed" || echo "❌ Trip Planner tests failed"
