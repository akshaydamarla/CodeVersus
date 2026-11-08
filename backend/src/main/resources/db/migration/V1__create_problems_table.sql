CREATE TABLE problems (
    id            BIGSERIAL PRIMARY KEY,
    title         VARCHAR(200) NOT NULL,
    slug          VARCHAR(200) NOT NULL UNIQUE,
    difficulty    VARCHAR(20)  NOT NULL,
    topics        TEXT[]       NOT NULL DEFAULT '{}',
    source        VARCHAR(50)  NOT NULL,
    reference_url VARCHAR(500),
    enabled       BOOLEAN      NOT NULL DEFAULT TRUE,
    CONSTRAINT chk_problems_difficulty
        CHECK (difficulty IN ('EASY', 'MEDIUM', 'HARD'))
);

CREATE INDEX idx_problems_difficulty_enabled
    ON problems (difficulty, enabled);