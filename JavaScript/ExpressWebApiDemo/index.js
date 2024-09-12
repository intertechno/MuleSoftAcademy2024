const express = require('express');
const fs = require('fs');
const path = require('path');

const app = express();
const port = 3000;

app.get('/', (req, res) => {
  res.send('Hello World from MuleSoft Academy!');
});

// Endpoint to get the current date and time
app.get('/datetime', (req, res) => {
    const now = new Date();
    res.json({ currentDateTime: now.toISOString() });
});

// Endpoint to calculate the sum of two numbers
app.get('/sum', (req, res) => {
    const num1 = parseFloat(req.query.num1);
    const num2 = parseFloat(req.query.num2);

    if (isNaN(num1) || isNaN(num2)) {
        return res.status(400).json({ error: 'Invalid numbers provided' });
    }

    const sum = num1 + num2;
    res.json({ sum });
});

// Endpoint to list persons from the Persons.csv file
app.get('/persons', (req, res) => {
    const filePath = path.join(__dirname, 'Persons.csv');
    
    fs.readFile(filePath, 'utf8', (err, data) => {
        if (err) {
            return res.status(500).json({ error: 'Failed to read file' });
        }
        
        const lines = data.split('\n');

        // take away the CSV title line by calling "shift"
        lines.shift();
        
        const persons = lines.map(line => {
            const [name, year, country] = line.split(',');
            const countryTrimmed = country.trim();
            return { name, year: parseInt(year, 10), country: countryTrimmed };
        }).filter(person => person.name); // Filter out any empty lines
        
        res.json({ persons });
    });
});

app.listen(port, () => {
  console.log(`Example app listening on URL http://localhost:${port}/`);
});
