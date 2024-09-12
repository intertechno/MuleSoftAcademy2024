const express = require('express');
const app = express();
const fs = require('fs');

// Insecure code: reading files based on user input, prone to Directory Traversal
app.get('/read_file', (req, res) => {
    const filename = req.query.filename;

    // Directly using user input to access files
    fs.readFile(`./files/${filename}`, 'utf8', (err, data) => {
        if (err) {
            return res.status(500).send('File not found or cannot be read');
        }
        res.send(data);
    });
});

app.listen(3000, () => {
    console.log('Server running on port 3000');
});
