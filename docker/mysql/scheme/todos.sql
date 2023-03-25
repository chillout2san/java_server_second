CREATE TABLE IF NOT EXISTS `todos` (
    `id` varchar(26) NOT NULL COMMENT 'todoのid',
    `name` varchar(255) NOT NULL COMMENT 'todoの名前',
    `content` varchar(255) NOT NULL COMMENT 'todoの内容',
    `status` enum('WORK_IN_PROGRESS', 'DONE') NOT NULL COMMENT 'todoのstatus',
    PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;