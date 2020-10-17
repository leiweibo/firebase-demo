# Pythono3 code to rename multiple
# files in a directory or folder

# importing os module
import os

# Function to rename multiple files
def main():
  with open('/Users/weibolei/cookies.txt') as f:
    cookies = f.read()

  dir = '/Users/weibolei/Downloads/images_127'
  targetDir = '/Users/weibolei/Downloads/target'
  for count, filename in enumerate(os.listdir(dir)):
    nameArray = filename.split('_')
    if (len(nameArray) != 3):
      continue
    ip = nameArray[0]
    method = nameArray[1]
    if (ip == ''):
      continue
    if (ip in cookies):
      os.rename(dir + "/" + filename, targetDir + "/" + method + "/" +filename)

# Driver Code
if __name__ == '__main__':
  # Calling main() function
  main()