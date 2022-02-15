#Ahmed
import requests
import json
respo = requests.get('https://api.the-odds-api.com/v4/sports/basketball_nba/scores/?daysFrom=1&apiKey=8d59a6f9e5550fd863e2f492f17d5dab')

with open('apiResp.txt', 'wb') as resp:
    lol = respo.content
    resp.write(lol)

print(respo.json())