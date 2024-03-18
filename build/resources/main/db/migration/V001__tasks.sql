CREATE TABLE tasks
(
    id         SERIAL PRIMARY KEY,
    task_title TEXT NOT NULL,
    done       BOOLEAN DEFAULT FALSE,
    created_at DATE NOT NULL
);
