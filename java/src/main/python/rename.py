# Pythono3 code to rename multiple
# files in a directory or folder

# importing os module
import os

# Function to rename multiple files
def main():
  dir = '/Users/weibolei/Downloads/mobilecleaner-8126e.appspot.com/images'
  for count, filename in enumerate(os.listdir(dir)):
    nameArray = filename.split('_')
    if (len(nameArray) != 3):
      continue
    print('old name:'.join(nameArray))
    newName = nameArray[1] + '_' + nameArray[2].split(".")[0] + "_" + nameArray[0]+"."+nameArray[2].split(".")[1]
    print('new name:' + newName)
    os.rename(dir + "/" + filename, dir + "/" + newName)

# Driver Code
if __name__ == '__main__':
  # Calling main() function
  main()