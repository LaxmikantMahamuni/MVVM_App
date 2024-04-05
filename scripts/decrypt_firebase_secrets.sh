INPUT_STRING=$1
BUILD_TYPE=$2

echo "********************** Get Encoded String **************************"

# Check if the input string is provided
if [ $# -eq 0 ]; then
  echo "Usage: $0 <input_ecoded_string>"
  exit 1
fi

echo "$1" | base64 --decode > ./app/src/"$2"/google-services.json

# Print the input string
echo "Input string: $1"

echo "******* Write Decoded string into Google-service.json file ***************"