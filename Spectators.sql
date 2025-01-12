-- Create the database
CREATE DATABASE spectators;

-- Use the database
USE spectators;

-- Create the matches table
CREATE TABLE matches (
    id INT PRIMARY KEY,              -- Match identifier
    mdate DATE NOT NULL,             -- Match date
    startsat TIME NOT NULL,          -- Match start time
    ticketprice DECIMAL(10, 2),      -- Ticket price
    mtype ENUM('championship', 'cup') NOT NULL -- Match type
);

-- Create the spectators table
CREATE TABLE spectators (
    id INT PRIMARY KEY,              -- Spectator identifier
    sname VARCHAR(255) NOT NULL,     -- Spectator name
    male BOOLEAN NOT NULL,           -- Gender (TRUE for male, FALSE for female)
    haspass BOOLEAN NOT NULL         -- Has pass (TRUE if pass, FALSE if buying tickets)
);

-- Create the entries table
CREATE TABLE entries (
    spectatorid INT,                 -- Foreign key to spectators
    matchid INT,                     -- Foreign key to matches
    timestamp DATETIME NOT NULL,     -- Entry time
    PRIMARY KEY (spectatorid, matchid), -- Composite primary key
    FOREIGN KEY (spectatorid) REFERENCES spectators(id),
    FOREIGN KEY (matchid) REFERENCES matches(id)
);
