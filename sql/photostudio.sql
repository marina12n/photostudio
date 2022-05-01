ALTER TABLE `photostudio`.`client` MODIFY COLUMN `ts` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;

INSERT INTO `photostudio`.`camera`
(`id`, `name`)
VALUES (1 , "Canon"), (2 , "Sony"), (3 , "Nikon");

INSERT INTO `photostudio`.`photographer`
(`name`, `camera_id`)
VALUES
("Bob", 1), ("Alice", 2), ("John", 3);

select photographer.id, photographer.name as "Name", camera.name as "Camera"
from photostudio.photographer
inner join photostudio.camera
on photographer.camera_id=camera.id;

INSERT INTO `photostudio`.`event`
(`name`)
VALUES ("Wedding"), ("Family"), ("Portrait");

INSERT INTO `photostudio`.`client`
(`name`, `phone_number`)
VALUES ("Boris", "+380950000000"), ("Joe", "+380981111111"), ("Ursula", "+380972222222");

INSERT INTO `photostudio`.`billing`
(`payment_type`, `event_id`, `client_id`)
VALUES
("Card", 1, 3), ("Cash", 3, 1), ("Card", 2, 2);

INSERT INTO `photostudio`.`price_list`
(`name`, `price`, `event_id`)
VALUES
("Standard", "500$", 1), ("Full", "900$", 1), ("Studio", "100$", 2);

UPDATE `photostudio`.`schedule`
SET
`name` = "Standard"
WHERE `id` = 1;

UPDATE `photostudio`.`billing`
SET
`payment_type` = "Cryptocurrency",
`event_id` = 2,
`client_id` = 3
WHERE `client_id` = 4 AND `id` = 4;

select billing.id as "№", billing.payment_type as "Pay", event.name as "Event", client.name as "Client",
client.phone_number as "Client Phone"
from photostudio.billing
inner join photostudio.event
	on billing.event_id=event.id
 inner join photostudio.client
	on billing.client_id=client.id;

SELECT * FROM photostudio.client ORDER BY ts DESC;
SELECT * FROM photostudio.client ORDER BY ts;
SELECT * FROM photostudio.client WHERE id=2;
SELECT * FROM photostudio.client WHERE name="Boris";

SELECT client.id as "ID", client.name as "Name", client.phone_number as "Phone", client.ts as "Registration Date"
FROM photostudio.client
LEFT JOIN photostudio.schedule
on client.id=schedule.client_id
WHERE schedule.id is NULL;




