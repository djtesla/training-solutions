create table activities(id BIGINT AUTO_INCREMENT, start_time TIMESTAMP, activity_desc VARCHAR(255), activity_type VARCHAR(255), PRIMARY KEY(id));
create table track_points(id BIGINT AUTO_INCREMENT, act_time TIMESTAMP, lat DOUBLE, lon DOUBLE, activity_id BIGINT, PRIMARY KEY(id), FOREIGN KEY(activity_id) REFERENCES activities (id));


