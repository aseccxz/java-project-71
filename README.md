### Hexlet tests and linter status:
[![Actions Status](https://github.com/aseccxz/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/aseccxz/java-project-71/actions)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=aseccxz_java-project-71&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=aseccxz_java-project-71)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=aseccxz_java-project-71&metric=coverage)](https://sonarcloud.io/summary/new_code?id=aseccxz_java-project-71)

## Вычислитель отличий ##
Этот проект – утилита, которая определяет разницу между двумя структурами данных.  
Возможности утилиты:  
* Поддержка разных входных форматов: yaml и json]  
* Генерация отчета в виде [plain](https://asciinema.org/a/rmNrrZTciTbec6pjNcnQOFoq5), [stylish](https://asciinema.org/a/udrKJcWccEkLZqc93Shdp8Uw2) и [json](https://asciinema.org/a/fXNkk7k8eIsN2GglQv2FCKnOt)  
Для запуска утилиты требуется передать два обязательных параметра - относительные или абсолютные пути для файлов и один необязательный - -f или --format  
Пример: /app file1.json file2.json -f plain

