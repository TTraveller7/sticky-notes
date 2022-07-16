-- insert plain_note
insert into PLAIN_NOTE(title, description, creation_timestamp)
values('Lorem Ipsum', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', '2022-06-18');
insert into PLAIN_NOTE(title, description, creation_timestamp)
values('Neque porro', 'Lquisquam est qui dolorem ipsum quia dolor sit amet, consectetur', '2022-06-18');

-- insert todo_note
insert into TODO_NOTE(title, description, creation_timestamp, category, status)
values('Spring', 'CRUD operations sec 11', '2022-06-18', 'WORK', 'TODO');
insert into TODO_NOTE(title, description, creation_timestamp, category, status)
values('Wash clothes', 'Wash all the clothes in the morning '
    || 'so that they could be dry before dinner', '2022-06-17', 'MISC', 'DONE');
