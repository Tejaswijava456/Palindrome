## How to test?

1. Install postgres (Install homebrew, brew install postgres), postgres app (Quick app for starting and stopping postgres services), pgadmin ( UI to configure postgres databases)
2. For running the app for first time, open PalindromeApplication.java, right click on main method and run
3. Once you run the above class, it'd create a new DB, new table on your local postgres server
4. For running again, you can change the property value of ddl-auto to update, so that it doesn't drop the existing table and create new one.
5. Open postman, hit the get endpoint with this URL - http://localhost:8080/palindrome/{inputString}
6. As soon as the above endpoint is hit, it creates the data in the table - palindrome_svc ( Can be checked using the pgadmin), then response could be seen the postman response.
7. Sample Response object:
```
{
    "Result": {
        "inputString": "abababbaba",
        "palindromeString": "ababbaba"
    }
}
```