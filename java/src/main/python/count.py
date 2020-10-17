# Pythono3 code to rename multiple
# files in a directory or folder

# importing os module
import os

# Function to rename multiple files
def main():
  dir = '/Users/weibolei/Downloads/mobilecleaner-8126e.appspot.com/images'
  dict1 = {}
  dict2 = {}
  for count, filename in enumerate(os.listdir(dir)):
    nameArray = filename.split('_')
    if (len(nameArray) != 3):
      continue

    key = nameArray[0]
    key2 = nameArray[0] + nameArray[1]
    dict1[key] = "1"
    dict2[key2] = "1"

  print(len(dict1))
  print(dict1)
  print(len(dict2))

# Driver Code
if __name__ == '__main__':
  # Calling main() function
  main()