# inventory-rest-api

#CREATE TABLE COMMAND
CREATE TABLE inventory (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    sku VARCHAR(255) NOT NULL UNIQUE,
    type VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    attributes JSON NOT NULL,
    cost DOUBLE NOT NULL,
    selling_price DOUBLE NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    created_by VARCHAR(255) NOT NULL
);
#insert data command
INSERT INTO inventory (
    sku,
    type,
    status,
    location,
    attributes,
    cost,
    selling_price,
    created_at,
    updated_at,
    created_by
) VALUES (
    'SKU001',
    'CAR',
    'AVAILABLE',
    'Warehouse A',
    '{
        "vin": "1HGCM82633A004352",
        "make": "Honda",
        "model": "Accord",
        "trim": "EX",
        "year": 2003
    }',
    20000.0,
    25000.0,
    NOW(),
    NOW(),
    'admin'
);

