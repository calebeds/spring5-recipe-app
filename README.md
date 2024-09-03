# Spring Boot Recipe Application

[![CircleCI](https://dl.circleci.com/status-badge/img/gh/calebeds/spring5-recipe-app/tree/main.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/calebeds/spring5-recipe-app/tree/main)
[![codecov](https://codecov.io/github/calebeds/spring5-recipe-app/graph/badge.svg?token=82F8BLEEOG)](https://codecov.io/github/calebeds/spring5-recipe-app)

## Steps

### Script
Run the script from `init-dbs.sql` in your mysql environment.

### Database passwords
The databases' passwords is on the `init-dbs.sql`. Feel free to change them before running the script on the previous step.

### Spring profile
Choose dev or prod spring profile before running the app. E.g: passing spring.profiles.active=dev on the Intellij running conf on the field env. Obs: when no profile is set, app is going to use h2.

### Run the app
After that, just run the app