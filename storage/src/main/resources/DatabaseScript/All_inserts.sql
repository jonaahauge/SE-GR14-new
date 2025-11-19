USE se; 
INSERT INTO kjoretoy(kjoretoy_navn, kjoretoy_id) VALUES
("Tog", 1),
("Buss", 2);

INSERT INTO rute (rute_id, rute_navn, kjoretoy_id) VALUES
(1,'Moss-Halden (Tog)', 1),
(2,'Halden-Moss (Tog)', 1),
(3,'Moss-Sarpsborg-Halden', 2),
(4,'Halden-Sarpsborg-Moss', 2),
(5,'Moss-Fredrikstad-Halden', 2),
(6,'Halden-Fredrikstad-Moss', 2),
(7,'Sarpsborg-Fredrikstad', 2),
(8,'Fredrikstad-Sarpsborg', 2),
(9,'Sarpsborg-Rakkestad', 2),
(10,'Rakkestad-Sarpsborg', 2);


INSERT INTO stoppested (stoppested_id, sted_navn) VALUES
(1,'Moss'),
(2,'Halden'),
(3,'Sarpsborg'),
(4,'Fredrikstad'),
(5,'Rakkestad'),
(6,'Rygge'),
(7,'Remmen'),
(8,'Greåker'),
(9,'Østfoldhallen'),
(10,'Borgenhaugen'),
(11,'Rudsskogen'),
(12,'Råde'), 
(13,'Saltnes'),
(14,'Ise'),
(15,'Solli'),
(16,'Viksletta'),
(17,'Gressvik'),
(18,'Kalnes'),
(19,'Skjeberg'),
(20,'Sandbakken'),
(21,'Begby'),
(22,'Skjærviken'),
(23, 'Bakke'),
(24, 'Svinesundparken');


INSERT INTO stoppested_has_rute (rute_id, stoppested_id, rekkefolge) VALUES
-- Rute 1: Moss-Halden (Tog)
(1, 1, 1),
(1, 6, 2),
(1, 12, 3),
(1, 4, 4),
(1, 3, 5),
(1, 2, 6),

-- Rute 2: Halden-Moss (Tog)
(2, 2, 1),
(2, 3, 2),
(2, 4, 3),
(2, 12, 4),
(2, 6, 5),
(2, 1, 6),  

-- Rute 3: Moss-Sarpsborg-Halden (Buss)
(3, 1, 1), 
(3, 6, 2),  
(3, 12, 3), 
(3, 15, 4), 
(3, 18, 5), 
(3, 3, 6),  
(3, 10, 7), 
(3, 20, 8), 
(3, 19, 9), 
(3, 16, 10),
(3, 24, 11),
(3, 7, 12), 
(3, 2, 13),

-- Rute 4: Halden-Sarpsborg-Moss (Buss)
(4, 2, 1), 
(4, 7, 2),  
(4, 24, 3), 
(4, 16, 4), 
(4, 19, 5), 
(4, 10, 7), 
(4, 18, 9), 
(4, 15, 10),
(4, 6, 12), 
(4, 1, 13), 
-- Rute 5: Moss-Fredrikstad-Halden (Buss)
(5, 1, 1),  
(5, 6, 2),  
(5, 13, 3), 
(5, 17, 4), 
(5, 4, 5),  
(5, 21, 6), 
(5, 22, 7), 
(5, 19, 8), 
(5, 16, 9), 
(5, 24, 10),
(5, 7, 11),
(5, 2, 12), 

-- Rute 6: Halden-Fredrikstad-Moss (Buss)
(6, 2, 1),  
(6, 7, 2),  
(6, 24, 3), 
(6, 16, 4), 
(6, 19, 5), 
(6, 22, 6),
(6, 21, 7), 
(6, 4, 8),  
(6, 17, 9), 
(6, 13, 10),
(6, 6, 11), 
(6, 1, 12), 

-- Rute 7: Sarpsborg-Fredrikstad (Buss)
(7, 3, 1),
(7, 8, 2),
(7, 9, 3),
(7, 4, 4),

-- Rute 8: Fredrikstad-Sarpsborg (Buss)
(8, 4, 1),
(8, 9, 2),
(8, 8, 3),
(8, 3, 4),

-- Rute 9: Sarpsborg-Rakkestad (Buss)
(9, 3, 1),
(9, 10, 2),
(9, 14, 3),
(9, 11, 4),
(9, 5, 5),

-- Rute 10: Rakkestad-Sarpsborg (Buss)
(10, 5, 1),
(10, 11, 2),
(10, 14, 3),
(10, 10, 4),
(10, 3, 5);