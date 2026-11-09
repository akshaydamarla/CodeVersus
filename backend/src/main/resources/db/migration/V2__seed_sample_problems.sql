INSERT INTO problems (title, slug, difficulty, topics, source, reference_url, enabled)
VALUES
    ('Pair With Target Sum', 'pair-with-target-sum', 'EASY',
     ARRAY['array', 'hash-map'], 'CODEVERSUS', NULL, TRUE),

    ('Balanced Brackets', 'balanced-brackets', 'EASY',
     ARRAY['string', 'stack'], 'CODEVERSUS', NULL, TRUE),

    ('Longest Unique Window', 'longest-unique-window', 'MEDIUM',
     ARRAY['string', 'sliding-window'], 'CODEVERSUS', NULL, TRUE),

    ('Merge Overlapping Ranges', 'merge-overlapping-ranges', 'MEDIUM',
     ARRAY['array', 'sorting'], 'CODEVERSUS', NULL, TRUE),

    ('Minimum Path Cost', 'minimum-path-cost', 'HARD',
     ARRAY['graph', 'dynamic-programming'], 'CODEVERSUS', NULL, TRUE),

    ('Work In Progress Problem', 'work-in-progress-problem', 'MEDIUM',
     ARRAY['array'], 'CODEVERSUS', NULL, FALSE);