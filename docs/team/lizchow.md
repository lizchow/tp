---
layout: page
title: Elizabeth Chow's Project Portfolio Page
---

### Project: PropertyWhiz

PropertyWhiz is a desktop application that helps property agents mangae their properties and clients.

Given below are my contributions to the project.

* **New Feature**: Added the `sort` command ([\#70](https://github.com/AY2122S1-CS2103T-W11-4/tp/pull/70)).
  * What it does: allows the user to sort the properties and clients by name and budgets in ascending/descending order.
  * Justification: This allows property agents to prioritise clients and priorities that are more valuable.
  * Highlights: Considered a variation of command formats, including using normal prefixes for easy parsing.
  * However, decided on the current format without the prefixes as it was easier to type but it required additional work to redesign the parser. 
  
* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2122s1.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2021-09-17&tabOpen=true&tabType=authorship&tabAuthor=lizchow&tabRepo=AY2122S1-CS2103T-W11-4%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=true)

* **Enhancements to existing features**:
  * Extended the `find` command to find properties and buyers by price range (Pull request [\#134](https://github.com/AY2122S1-CS2103T-W11-4/tp/pull/134))
  * Extended `AddressBook` to keep track of items currently displayed  so that all operations are only performed on the currently displayed lists. 

* **Documentation**:
  * User Guide:
    * Added documentation for the `sort` feature.
    * Added documentation for the `find` feature to filter within price range.
  * Developer Guide:
    * Added implementation details of the `sort` feature.

* **Community**:
  * PRs reviewed (with non-trivial review comments): [\#56](https://github.com/AY2122S1-CS2103T-W11-4/tp/pull/56), [\#58](https://github.com/AY2122S1-CS2103T-W11-4/tp/pull/58)
  * Reported bugs and suggestions for other teams in the class ([PE-D issues](https://github.com/lizchow/ped/issues))
  
