select photographer.id, photographer.name as "Name", camera.name as "Camera"
from photostudio.photographer
inner join photostudio.camera
on photographer.camera_id=camera.id;