## **문제점 1: `collectionSalePrice` 데이터 타입**

- **문제**
    - 첫 번째 객체의 `collectionSalePrice`는 `null`로 설정되어 있지만, 두 번째 객체에서는 `List`로 설정
    - 데이터 처리 시 **NPE를 발생 시킬 가능성**이 있음
- **해결 방안**
    - `collectionSalePrice`를 항상 `List`로 설정하고, 값이 없으면 빈 배열 `[]`로 처리
    - JSON 수정:

        ```json
        {
          "collectionChartDataList": [
            {
              "collectionName": "collectionName",
              "collectionSalePrice": []
            },
            {
              "collectionName": "collectionName",
              "collectionSalePrice": [
                {
                  "price": 59.75,
                  "cvtDatetime": "2023-03-26T08:08:35"
                },
                {
                  "price": 60.00,
                  "cvtDatetime": "2023-03-26T08:08:45"
                }
              ]
            }
          ]
        }
        ```

---

## **문제점 2: 중복된 `collectionName`**

- **문제**
    - 두 개의 객체 모두 `collectionName` 값이 동일
    - 데이터베이스나 클라이언트에서 이 값으로 데이터를 구분하려 한다면, 충돌이 발생할 가능성 존재
- **해결 방안**:
    - `id` 와 같은 식별할 수 있는 필드를 추가
    - 또는 `collectionName`을 고유한 값으로 설정
    - JSON 수정:

        ```json
        {
          "collectionChartDataList": [
            {
              "collectionId": 1,
              "collectionName": "collectionName",
              "collectionSalePrice": []
            },
            {
              "collectionId": 2,
              "collectionName": "collectionName",
              "collectionSalePrice": [
                {
                  "price": 59.75,
                  "cvtDatetime": "2023-03-26T08:08:35"
                },
                {
                  "price": 60.00,
                  "cvtDatetime": "2023-03-26T08:08:45"
                }
              ]
            }
          ]
        }
        ```

---

## 최종 JSON 수정

```json
[
   {
     "collectionId": 1,
     "collectionName": "collectionName",
     "collectionSalePrice": []
   },
   {
     "collectionId": 2,
     "collectionName": "collectionName",
     "collectionSalePrice": [
       {
         "price": 59.75,
         "cvtDatetime": "2023-03-26T08:08:35"
       },
       {
         "price": 60.00,
         "cvtDatetime": "2023-03-26T08:08:45"
       }
     ]
   }
 ]
```