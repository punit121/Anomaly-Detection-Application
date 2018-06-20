echo "Stopping Hawkeye Service at $1 if already running".
fuser -k $1/tcp
echo "Starting Hawkeye Service at $1 with profile $3"
java -jar /opt/hawkeye/$2/target/AnamolyDetectionApp-0.0.1-SNAPSHOT.jar --spring.profiles.active=$3