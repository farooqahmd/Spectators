// Login endpoint
app.post('/login', (req, res) => {
    const { username, password } = req.body;
    if (username === 'admin' && password === 'password') {
        res.json({ success: true, message: 'Login successful!' });
    } else {
        res.status(401).json({ success: false, message: 'Invalid credentials' });
    }
});

// CRUD endpoints
app.post('/createSpectator', (req, res) => {
    const { id, name } = req.body;
    client.createMatch({ matchid: id, sname: name }, (err, response) => {
        if (err) {
            return res.status(500).send(err.message);
        }
        res.json(response);
    });
});

app.post('/getSpectatorById', (req, res) => {
    const { id } = req.body;
    client.getSpectatorById({ id }, (err, response) => {
        if (err) {
            return res.status(500).send(err.message);
        }
        res.json(response);
    });
});

app.post('/updateSpectator', (req, res) => {
    const { id, name } = req.body;
    // Placeholder: replace with actual gRPC update logic
    res.json({ success: true, message: `Updated spectator with ID ${id} to name ${name}` });
});

app.post('/deleteSpectator', (req, res) => {
    const { id } = req.body;
    // Placeholder: replace with actual gRPC delete logic
    res.json({ success: true, message: `Deleted spectator with ID ${id}` });
});
