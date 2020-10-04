#Create Database
CREATE DATABASE StarDust;

#Create Tables
#create Customer Table
CREATE TABLE Customer
(
	customerID INT NOT NULL AUTO_INCREMENT,
    fName VARCHAR(50) NOT NULL,
    lName VARCHAR(50) NOT NULL,
    phone INT(11) NOT NULL,
    email VARCHAR(255) NOT NULL,
    NIC VARCHAR(12) NOT NULL,
    password VARCHAR(1024) NOT NULL,
    addressLine1 VARCHAR(255) NOT NULL,
    addressLine2 VARCHAR(255) NOT NULL,
    addressLine3 VARCHAR(255),
    registeredDateTime DATETIME,
    PRIMARY KEY(customerID)
);


#create Vehicle Table
CREATE TABLE Vehicle
(
	vehicleID INT NOT NULL AUTO_INCREMENT,
    vehicleType VARCHAR(255) NOT NULL,
    vehicleBrand VARCHAR(255) NOT NULL,
    vehicleModel VARCHAR(255) NOT NULL,
    lastService DATE,
    engineNumber CHAR(10) NOT NULL,
    engineCapacity VARCHAR(10) NOT NULL,
    wheelSize VARCHAR(100) NOT NULL,
    fuelCapacity FLOAT NOT NULL,
    customerID INT,
    PRIMARY KEY(vehicleID),
    CONSTRAINT Fk_vehicle_Customer FOREIGN KEY(customerID) REFERENCES Customer(customerID) ON UPDATE CASCADE ON DELETE CASCADE
);

#create Branch Table
CREATE TABLE Branch
(
	branchID INT NOT NULL AUTO_INCREMENT,
    bName VARCHAR(50) NOT NULL,
    phone INT(11) NOT NULL,
    email VARCHAR(255) NOT NULL,
    addressLine1 VARCHAR(255) NOT NULL,
    addressLine2 VARCHAR(255) NOT NULL,
    addressLine3 VARCHAR(255),
    PRIMARY KEY(branchID)
);

#create Staff Table
CREATE TABLE Staff
(
	sID INT NOT NULL AUTO_INCREMENT,
    fName VARCHAR(50) NOT NULL,
    lName VARCHAR(50) NOT NULL,
    phone INT(11) NOT NULL,
    email VARCHAR(255) NOT NULL,
    NIC VARCHAR(12) NOT NULL,
    password VARCHAR(255) NOT NULL,
    addressLine1 VARCHAR(255) NOT NULL,
    addressLine2 VARCHAR(255) NOT NULL,
    addressLine3 VARCHAR(255),
    occupation VARCHAR(100) NOT NULL,
    salary FLOAT NOT NULL,
    branchID INT NOT NULL,
    startDate DATE,
    PRIMARY KEY(sID),
    CONSTRAINT Fk_Staff_Branch FOREIGN KEY(branchID) REFERENCES Branch(branchID) ON UPDATE CASCADE ON DELETE CASCADE
);

#create Service Table
CREATE TABLE Service
(
	serviceID INT NOT NULL AUTO_INCREMENT,
    serviceType VARCHAR(100),
    bookDate DATE,
    bookTime TIME,
    requestDate DATETIME,
    amount FLOAT,
    customerID INT,
    vehicleID INT,
    branchID INT,
    PRIMARY KEY(serviceID),
    CONSTRAINT Fk_Service_Customer FOREIGN KEY(customerID) REFERENCES Customer(customerID) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT Fk_Service_Vehicle FOREIGN KEY(vehicleID) REFERENCES Vehicle(vehicleID) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT Fk_Service_Branch FOREIGN KEY(branchID) REFERENCES Branch(branchID) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Contact_Registered
(
	contactID int AUTO_INCREMENT,
    name VARCHAR(255),
    email VARCHAR(255),
    phone INT,
    message VARCHAR(5000),
    customerID INT,
    PRIMARY KEY(contactID),
    CONSTRAINT Fk_Contact_Customer FOREIGN KEY(customerID) REFERENCES Customer(customerID) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Contact_UnRegistered
(
	contactID int AUTO_INCREMENT,
    name VARCHAR(255),
    email VARCHAR(255),
    phone INT,
    message VARCHAR(5000),
    PRIMARY KEY(contactID)
);




#Insert Data Into Tables
#Insert Data into the Customer Table
INSERT INTO Customer(fName, lName, phone, email, NIC, password, addressLine1, addressLine2, addressLine3, registeredDateTime) VALUES ("John", "Doe", 0701122123, "john.d@gmail.com", "890763076V", "john123", "No:20", "Colombo Road", "Malabe", now());
INSERT INTO Customer(fName, lName, phone, email, NIC, password, addressLine1, addressLine2, addressLine3, registeredDateTime) VALUES ("Mary", "Jane", 0768687880, "mary.j@yahoo.com", "787807865V", "mary123", "Mary", "Kohuwala Road", "Nugegoda", now());
INSERT INTO Customer(fName, lName, phone, email, NIC, password, addressLine1, addressLine2, addressLine3, registeredDateTime) VALUES ("Will", "Parker", 0723456765, "will23@gmail.com", "900761034V", "will123", "No:5", "Galle Road", "Matara", now());
INSERT INTO Customer(fName, lName, phone, email, NIC, password, addressLine1, addressLine2, addressLine3, registeredDateTime) VALUES ("Franz", "Josef", 0716972584, "Franz68@gmail.com", "680788064V", "iamarobot", "B47", "Sri Jayawardenepura", "Kotte", now());
INSERT INTO Customer(fName, lName, phone, email, NIC, password, addressLine1, addressLine2, addressLine3, registeredDateTime) VALUES ("Karl", "Benz", 0763258741, "Karl@gmail.com", "650769054V", "karal1", "No:31", "Hendala Road", "Matara", now());
INSERT INTO Customer(fName, lName, phone, email, NIC, password, addressLine1, addressLine2, addressLine3, registeredDateTime) VALUES ("Henry", "Ford", 0724569251, "Fordgo@gmail.com", "724793024V", "rickmorty", "1124/5", "Parliament Road", "Battaramulla", now());
INSERT INTO Customer(fName, lName, phone, email, NIC, password, addressLine1, addressLine2, addressLine3, registeredDateTime) VALUES ("Dilantha", "Malagamuwa", 0777999110, "dilangoracing@gmail.com", "631994097V", "lamborghini", "4", "Sudarshana Mawatha", "Colombo", now());
INSERT INTO Customer(fName, lName, phone, email, NIC, password, addressLine1, addressLine2, addressLine3, registeredDateTime) VALUES ("Amith", "Dikwella", 0713864888, "dikwella32@gmail.com", "910930791V", "endgame", "37", "Wasala Rd", "Dehiwala-Mount Lavinia", now());
INSERT INTO Customer(fName, lName, phone, email, NIC, password, addressLine1, addressLine2, addressLine3, registeredDateTime) VALUES ("Buddika", "Minuwan", 0716776776, "minu@gmail.com", "953787491V", "marvel123", "611/1", "Negombo Rd", "Wattala", now());
INSERT INTO Customer(fName, lName, phone, email, NIC, password, addressLine1, addressLine2, addressLine3, registeredDateTime) VALUES ("Himantha", "Akalanka", 0711858896, "akalankaaro@gmail.com", "803414119V", "mirroryes", "155", "Horana", "Boralesgamuwa", now());

#Insert Data into the Vehicle Table
INSERT INTO Vehicle(vehicleType, vehicleBrand, vehicleModel, lastService, engineNumber, engineCapacity, wheelSize, fuelCapacity, customerID) VALUES ("Car", "Toyota", "Axio 2018", "2019-01-01", "52WVC10338", "1496CC", "185/70 R14", 50, 3);
INSERT INTO Vehicle(vehicleType, vehicleBrand, vehicleModel, lastService, engineNumber, engineCapacity, wheelSize, fuelCapacity, customerID) VALUES ("Car", "Toyota", "Camri 2018", "2019-01-01", "52WVC90898", "1998CC", "215/60 R16", 70, 7);
INSERT INTO Vehicle(vehicleType, vehicleBrand, vehicleModel, lastService, engineNumber, engineCapacity, wheelSize, fuelCapacity, customerID) VALUES ("Van", "Ford", "AEROSTAR XLT 1997", "2018-07-01", "45CDS10338", "800CC", "P215/70 R14", 79.5, 2);

#Insert Data into the Branch Table
INSERT INTO Branch(bName, phone, email, addressLine1, addressLine2, addressLine3) VALUES ("Malabe", 0112745674, "info@malabe.stardust.vc.com", "No:25", "Colombo Road", "Malabe");
INSERT INTO Branch(bName, phone, email, addressLine1, addressLine2, addressLine3) VALUES ("Maharagama", 0113456574, "info@maharagama.stardust.vc.com", "No:5", "Colombo Road", "Maharagama");
INSERT INTO Branch(bName, phone, email, addressLine1, addressLine2, addressLine3) VALUES ("Nugegoda", 0112123454, "info@nugegoda.stardust.vc.com", "No:26", "Nawala Road", "Nugegoda");
INSERT INTO Branch(bName, phone, email, addressLine1, addressLine2, addressLine3) VALUES ("Baththaramulla", 0113456704, "info@baththaramulla.stardust.vc.com", "No:20", "Pannipitiya Road", "Baththaramulla");
INSERT INTO Branch(bName, phone, email, addressLine1, addressLine2, addressLine3) VALUES ("Kollupitiya", 0112723412, "info@kollupitiya.stardust.vc.com", "No:125/A", "Galle Road", "Kollupitiya");
INSERT INTO Branch(bName, phone, email, addressLine1, addressLine2, addressLine3) VALUES ("Kandy", 0114567909, "info@kandy.stardust.vc.com", "No:15", "Matale Road", "Kandy");
INSERT INTO Branch(bName, phone, email, addressLine1, addressLine2, addressLine3) VALUES ("Galle", 01213456780, "info@galle.stardust.vc.com", "No:25", "Akuressa Road", "Galle");
INSERT INTO Branch(bName, phone, email, addressLine1, addressLine2, addressLine3) VALUES ("Matara", 0112743235, "info@matara.stardust.vc.com", "No:20", "Galle Road", "Matara");

#Insert Data Into the Staff Table
INSERT INTO Staff(fName, lName, phone, email, NIC, password, addressLine1, addressLine2, addressLine3, occupation, salary, branchID, startDate) VALUES ("Mohan", "Fernando", 0713392234, "mohan.f@gmail.com", "850802312V", "mohan123", "No:1", "New Kandy Road", "Malabe", "Owner", 50000.00, 1, "2019-01-01");
INSERT INTO Staff(fName, lName, phone, email, NIC, password, addressLine1, addressLine2, addressLine3, occupation, salary, branchID, startDate) VALUES ("Janaka", "Perera", 0765412334, "janaka89@gmail.com", "890801562V", "janaka123", "No:13", "New Kandy Road", "Malabe", "Manager", 30000.00, 1, "2019-01-01");
INSERT INTO Staff(fName, lName, phone, email, NIC, password, addressLine1, addressLine2, addressLine3, occupation, salary, branchID, startDate) VALUES ("Wasantha", "Nanayakkara", 0703392904, "wasantha123@gmail.com", "850605612V", "wasantha123", "No:45", "Athurugiriya Road", "Godagama", "Manager", 30000.00, 2, "2019-01-05");
INSERT INTO Staff(fName, lName, phone, email, NIC, password, addressLine1, addressLine2, addressLine3, occupation, salary, branchID, startDate) VALUES ("Walter", "White", 0713392123, "walter.w@gmail.com", "750802312V", "walter123", "No:34", "New Kandy Road", "Halawatha", "Admin", 30000.00, 1, "2019-01-01");

#Insert Data Into the Service Table
INSERT INTO Service(serviceType, bookDate, bookTime, requestDate, amount, customerID, vehicleID, branchID) VALUES ("Full", "2019-04-29", "20:40:45", now(), 1500.00, 3, 5, 1);

#Insert Data Into the Contact_Registered Table
INSERT INTO Contact_Registered(name, email, phone, message, customerID) VALUES ("John Doe", "john.d@gmail.com", 0701122123, "I would like to thank you all for these amazing web site you have. You know your service allow me to do my work easily. Thank you everyone! Appreciate this!", 7);

#Insert Data Into the Contact_UnRegistered Table
INSERT INTO Contact_UnRegistered(name, email, phone, message) VALUES ("Abraham Wilson", "abraham.d@gmail.com", 0701122123, "Best regards from Abraham!");





#Display Tables
#Display Customer Table
SELECT * FROM Customer;

#Display Vehicle Table
SELECT * FROM Vehicle;

#Display Branch Table
SELECT * FROM Branch;

#Display Staff Table
SELECT * FROM Staff;

#Display Service Table
SELECT * FROM Service;

#Display Contact_Registered Table
SELECT * FROM Contact_Registered;

#Display Contact_UnRegistered Table
SELECT * FROM Contact_UnRegistered;






#Drop Tables
#Drop Contact_Registered Table
DROP TABLE Contact_Registered;

#Drop Contact_UnRegistered Table
DROP TABLE Contact_UnRegistered;

#Drop Service Table
DROP TABLE Service;

#Drop Staff Table
DROP TABLE Staff;

#Drop Branch Table
DROP TABLE Branch;

#Drop Vehicle table
DROP TABLE Vehicle;

#Drop Customer Table
DROP TABLE Customer;






#Other Samples
DELETE FROM Vehicle WHERE vehicleID = 2;

DELETE FROM Customer WHERE customerID = 6;

DELETE FROM Contact_UnRegistered WHERE contactID = 3;
DELETE FROM Contact_Registered WHERE contactID = 1;

SELECT * FROM Vehicle WHERE customerID = (SELECT customerID FROM Customer WHERE email = "john.d@gmail.com");