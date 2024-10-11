
## API Endpoints

You can use **POSTMAN** to try the following endpoints:

### Get a list of all animals

**Request**:
```bash
GET /api/animals/all
```
**URL**:
```
http://localhost:8080/api/animals/all
```
**Response**:
```json
[
  {
    "animalId": 1,
    "name": "Lion",
    "scientificName": "Panthera leo",
    "species": "Mammal",
    "habitat": "Savannah",
    "description": "A large carnivorous feline"
  },
  {
    "animalId": 2,
    "name": "Elephant",
    "scientificName": "Loxodonta africana",
    "species": "Mammal",
    "habitat": "Savannah",
    "description": "Largest land animal"
  }
]
```

### Get a specific animal by its ID

**Request**:
```bash
GET /api/animals/{animalId}
```
**URL**:
```
http://localhost:8080/api/animals/1
```
**Response**:
```json
{
  "animalId": 1,
  "name": "Lion",
  "scientificName": "Panthera leo",
  "species": "Mammal",
  "habitat": "Savannah",
  "description": "A large carnivorous feline"
}
```

### Create a new animal

**Request**:
```bash
POST /api/animals/new
```
**URL**:
```
http://localhost:8080/api/animals/new
```
**Body** (example JSON):
```json
{
  "name": "Tiger",
  "scientificName": "Panthera tigris",
  "species": "Mammal",
  "habitat": "Forest",
  "description": "A large carnivorous feline"
}
```
**Response**:
```json
{
  "animalId": 3,
  "name": "Tiger",
  "scientificName": "Panthera tigris",
  "species": "Mammal",
  "habitat": "Forest",
  "description": "A large carnivorous feline"
}
```

### Update an existing animal

**Request**:
```bash
PUT /api/animals/update/{animalId}
```
**URL**:
```
http://localhost:8080/api/animals/update/1
```
**Body** (example JSON):
```json
{
  "name": "Updated Lion",
  "scientificName": "Panthera leo",
  "species": "Mammal",
  "habitat": "Savannah",
  "description": "Updated description for lion"
}
```
**Response**:
```json
{
  "animalId": 1,
  "name": "Updated Lion",
  "scientificName": "Panthera leo",
  "species": "Mammal",
  "habitat": "Savannah",
  "description": "Updated description for lion"
}
```

### Delete an existing animal

**Request**:
```bash
DELETE /api/animals/delete/{animalId}
```
**URL**:
```
http://localhost:8080/api/animals/delete/1
```
**Response**:
```json
[
  {
    "animalId": 2,
    "name": "Elephant",
    "scientificName": "Loxodonta africana",
    "species": "Mammal",
    "habitat": "Savannah",
    "description": "Largest land animal"
  },
  {
    "animalId": 3,
    "name": "Tiger",
    "scientificName": "Panthera tigris",
    "species": "Mammal",
    "habitat": "Forest",
    "description": "A large carnivorous feline"
  }
]
```

### Get animals by species

**Request**:
```bash
GET /api/animals/species?species=Mammal
```
**URL**:
```
http://localhost:8080/api/animals/species?species=Mammal
```
**Response**:
```json
[
  {
    "animalId": 1,
    "name": "Lion",
    "scientificName": "Panthera leo",
    "species": "Mammal",
    "habitat": "Savannah",
    "description": "A large carnivorous feline"
  },
  {
    "animalId": 2,
    "name": "Elephant",
    "scientificName": "Loxodonta africana",
    "species": "Mammal",
    "habitat": "Savannah",
    "description": "Largest land animal"
  }
]
```

### Search for animals by name

**Request**:
```bash
GET /api/animals/search?name=Lion
```
**URL**:
```
http://localhost:8080/api/animals/search?name=Lion
```
**Response**:
```json
[
  {
    "animalId": 1,
    "name": "Lion",
    "scientificName": "Panthera leo",
    "species": "Mammal",
    "habitat": "Savannah",
    "description": "A large carnivorous feline"
  }
]
