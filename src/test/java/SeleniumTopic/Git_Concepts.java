package SeleniumTopic;

public class Git_Concepts {
    /***
     1. What are the different stages in committing the code to GitHub?
             The process involves several stages:
     Working Directory (Untracked/Modified):

             You make changes to files in your local working directory.
             Staging Area (Indexed):

             Use git add <file> to stage the changes you want to commit.
             Example: git add . (adds all changes)
             Local Repository (Committed):

             Commit the staged changes using git commit -m "commit message".
             This saves the changes to the local repository.
             Remote Repository (Pushed):

             Push the committed changes to GitHub using git push origin <branch-name>.
             Example Workflow:

             bash
             Copy
             Edit
             git add .
             git commit -m "Added new feature"
             git push origin main
     2. Is it possible to revert changes in a remote repository? If yes, how?
             Yes, you can revert changes in a remote repository using the following methods:

             Method 1: Using git revert (Safe Approach)
             This creates a new commit that undoes the changes without altering commit history.

             bash
             Copy
             Edit
             git revert <commit-hash>
             git push origin <branch-name>
             Method 2: Using git reset (Destructive Approach)
             If you want to remove commits and rewrite history (use with caution):

             bash
             Copy
             Edit
             git reset --hard <commit-hash>  # Reset to a previous commit
             git push origin <branch-name> --force  # Force push changes
             ⚠️ Be cautious, as force-pushing can overwrite history and impact other developers.

     Method 3: Deleting the branch and recreating it (if necessary)

             bash
             Copy
             Edit
             git push origin --delete <branch-name>
             git checkout -b <branch-name>
             git push origin <branch-name>
             3. When do you commit your code? After committing, how do you validate that everyone has the updated code?
             When to commit:

             After completing a logically independent unit of work.
             When tests pass and the code is reviewed.
             When following the team's commit frequency guidelines.
             Validation steps after committing:

             Push the changes to the remote repository (git push).
             Ask team members to pull the latest changes using:
             bash
             Copy
             Edit
             git pull origin <branch-name>
             Verify the commit history using:
             bash
             Copy
             Edit
             git log --oneline
             Check for merge conflicts and resolve if needed.
     4. How to merge stashed changes in a local repository?
     To merge stashed changes:

                 View stashes:

                 bash
                 Copy
                 Edit
                 git stash list
                 Apply the latest stash:

                 bash
                 Copy
                 Edit
                 git stash apply
                 This applies the changes but keeps the stash for future use.
                 Apply and delete the stash:

                 bash
                 Copy
                 Edit
                 git stash pop
                 This applies the changes and removes the stash.
                 Apply a specific stash (if multiple exist):

                 bash
                 Copy
                 Edit
                 git stash apply stash@{1}
     5. Why do we need a .gitignore file? How do you add files to it?
                 Purpose of .gitignore:

                 It prevents unnecessary or sensitive files (e.g., logs, environment files, compiled binaries) from being tracked by Git.
                 Helps to keep the repository clean and efficient.
                 How to add files to .gitignore:

                 Open or create the .gitignore file in the root of the repository.
                 Add the filenames or patterns to ignore, e.g.:
                 bash
                 Copy
                 Edit
                 node_modules/
                 .env
                 *.log
                 build/
                 Example to add a new file to ignore:

                 bash
                 Copy
                 Edit
                 echo "config.json" >> .gitignore
                 git add .gitignore
                 git commit -m "Updated .gitignore"
                 git push origin main
                 */
}
