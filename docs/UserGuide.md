---
layout: page
title: User Guide
---

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Introduction

PropertyWhiz (PropertyWhiz) is a **desktop app for managing properties and property buyers, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, PropertyWhiz can get your tasks done faster than traditional GUI apps.

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `propertywhiz.jar` from [here]().

1. Copy the file to the folder you want to use as the _home folder_ for your PropertyWhiz.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
    
   ![Ui](images/Ui.png)
   
1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

    * **`clear`** : Deletes all properties/buyers. Enter `clear` start from scratch!

    * **`list`** : Lists all properties/buyers.

    * **`add`** Adds a property/buyer.
        * e.g. `add property n/Blk 123 a/123, Clementi Rd, #04-20, 1234665 s/James Lee p/61234567 e/example@email.com $/100000 t/HDB t/3rm`

    * **`delete`** : Deletes a property/buyer shown in the current list at the given index.
        * e.g. `delete property 3`
        * e.g. `delete buyer 3`

    * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command, 
   or the [Command Summary](#command-summary).

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | **Property** <br>`add property n/PROPERTY_NAME a/PROPERTY_ADDRESS s/SELLER_NAME p/SELLER_PHONE e/SELLER_EMAIL $/PRICE [t/TAG]…​` <br> e.g., `add property n/Blk 123 a/123, Clementi Rd, #04-20, 1234665 s/James Lee sp/61234567 $/100000 t/HDB t/3rm` <br><br> **Buyer** <br>`add buyer n/BUYER_NAME p/BUYER_PHONE e/BUYER_EMAIL $/BUDGET) [t/TAG]…` <br> e.g., `add buyer n/Sam p/91234567 e/sam@email.com $/740000 t/hdb t/3rm`
**Clear** | `clear`
**Delete** | `delete (property \| buyer) INDEX`<br> e.g., `delete property 3`
**Edit** | **Property** <br>`edit property INDEX [n/PROPERTY_NAME] [a/PROPERTY_ADDRESS] [s/SELLER_NAME] [p/SELLER_PHONE] [e/SELLER_EMAIL] [$/PRICE] [([t/TAG]…​ \| [ta/TAG_TO_ADD]… [td/TAG_TO_DELETE]…)]]​`<br> e.g.,`edit property 2 s/James Lee e/jameslee@example.com` <br><br> **Buyer** <br> `edit buyer INDEX [n/BUYER_NAME] [p/BUYER_PHONE] [e/BUYER_EMAIL] [$/BUDGET]) [([t/TAG]… \| [ta/TAG_TO_ADD]… [td/TAG_TO_DELETE]…)]` <br> e.g.,`edit buyer 2 n/Victor Lee p/88887777`
**Find** | `find (properties \| buyers) [KEYWORDS] [t/TAG_TO_MATCH]…`<br> e.g., `find Jurong t/4rm t/near school`
**List** | `list`
**Exit** | `exit`
**Help** | `help`
**Sort** | `sort (properties \| buyers) (price \| name) (asc \| desc)`
**Match** | `match ( auto \| property INDEX \| buyer INDEX )`
**Import** | `import (properties \| buyers)`
**Export** | `export (properties \| buyers)`

--------------------------------------------------------------------------------------------------------------------

## Navigating the User Interface

![Ui](images/NavigatingUi.png)

The UI is split into the input and output sections, as well as
two view columns for **Property** and **Buyer** each.

![](images/PropertyCardUi.png)

Here is the breakdown of an individual property card.

Item | Description
--------|------------------
**Name** | Name of property listing.
**Price** | Quoted price of seller.
**Address** | Address of property listing.
**Seller** | Name of seller.
**Phone** | Phone number of seller.
**Email** | Email of seller.

![](images/BuyerCardUi-03.png)

Here is the breakdown of an individual buyer card.

Item | Description
--------|------------------
**Name** | Name of buyer.
**Budget** | The buyer's budget.
**Phone** | Phone number of buyer.
**Email** | Email of buyer.

--------------------------------------------------------------------------------------------------------------------

## Features

TODO: Define named parameters, positional parameters

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add property n/PROPERTY_NAME`, `PROPERTY_NAME` is a parameter which can be used as `add property n/Beautiful Condo`.

* Items in square brackets are optional.<br>
  e.g `n/PROPERTY_NAME [t/TAG]` can be used as `n/Beautiful Condo t/condo` or as `n/Beautiful Condo`.

* Items with `…` after them can be repeated any number of times.<br>
  e.g. `[t/TAG]…` can be omitted, used once:`t/condo`, twice:`t/condo t/family` or more times.

* Items in circle brackets `()` separated by `|` means that you can only choose 1 of the partitioned items <br>
  e.g. `([t/TAG] | [ta/TAG_TO_ADD] [t/TAG_TO_DELETE])` can be used as `t/condo`, `ta/condo td/small condo` but not `t/condo ta/condo`, `t/condo td/small condo`, `t/condo ta/condo td/small condo`

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `p/12341234 p/56785678`, only `p/56785678` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

------------------

TODO: I suggest we centralize common input requirements here.
### Valid Fields
Here are some fields that are shared amongst commands.

#### Property/Buyer names
* Names must start with a letter or number, and only contain alphanumerical characters, spaces and hyphens (`-`).
* Names have a maximum allowed length of 50.

#### Property Prices/Buyer Budget
* Prices must be between 4 and 9 digits (both inclusive).
* Leading zeroes will be ignored. For e.g., `00100` has 5 characters, but it only has 3 digits, not counting the leading 0s. Hence, `00100` is an invalid price.

#### Tags
* Tags are always optional.
* Tags must start with a letter or number, and only contain alphanumerical characters, spaces and hyphens (`-`).
* Tags have a maximum allowed length of 100.

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`


### Adding a property/buyer: `add`

Adds a property/buyer to PropertyWhiz.

* All other fields are compulsory other than tags.

See [valid inputs](#valid-fields) for details on constraints on what you can enter.

Format:
* Adding a property: `add property n/PROPERTY_NAME a/PROPERTY_ADDRESS s/SELLER_NAME p/SELLER_PHONE e/SELLER_EMAIL $/PRICE [t/TAG]…`
* Adding a buyer: `add buyer n/BUYER_NAME p/BUYER_PHONE e/BUYER_EMAIL $/BUDGET [t/TAG]…`

Examples:
* `add property n/Blk 123 a/123, Clementi Rd, #04-20, 1234665 s/James Lee p/61234567 e/james@email.com $/100000 t/hdb t/3rm`
* `add buyer n/Sam p/91234567 e/sam@email.com $/740000 t/hdb t/3rm`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A property/buyer can have any number of tags (including 0). All tags will be converted to lowercase.
</div>


### Listing all properties/buyers : `list`

Shows a list of all properties and buyers in PropertyWhiz.

Format: `list`


### Editing a property/buyer : `edit`

Edits the property/buyer at the specified `INDEX`. The index refers to the index number shown in the displayed property/buyer list. The index **must be a positive integer** 1, 2, 3, …
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the property will be removed i.e adding of tags is not cumulative.
* Like `add`, tags added via `edit` will be automatically converted to lower case.
* You can remove all the property/buyer’s tags by typing `t/` without specifying any tags after it.

See [valid inputs](#valid-fields) for details on constraints on what you can enter.

Format:
* Editing a property: `edit property INDEX [n/PROPERTY_NAME] [a/PROPERTY_ADDRESS] [s/SELLER_NAME] [p/SELLER_PHONE] [e/SELLER_EMAIL] [$/PRICE] [([t/TAG]… | [ta/TAG_TO_ADD]… [td/TAG_TO_DELETE]…)]`
* Editing a buyer: `edit buyer INDEX [n/BUYER_NAME] [p/BUYER_PHONE] [e/BUYER_EMAIL] [$/BUDGET] [([t/TAG]… | [ta/TAG_TO_ADD]… [td/TAG_TO_DELETE]…)]`

Examples:
* `edit property 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st property to be `91234567` and `johndoe@example.com` respectively.
* `edit property 2 n/Blk 298 Toa Payoh Central t/` Edits the name of the 2nd property to be `Blk 298 Toa Payoh Central` and clears all existing tags.
* `edit buyer 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st buyer to be `91234567` and `johndoe@example.com` respectively.
* `edit property 1 ta/4rm ta/near mrt` Edits the tag list of the 1st property by adding two tags called "4rm" and "near mrt" if they are not already present in the original tag list.
* `edit property 1 ta/4rm td/near mrt` Edits the tag list of the 1st property by adding a tag called "4rm" if it does not already exist in the original tag list and removing a tag called "near mrt" if it is present in the original tag list.
* `edit property 1 ta/near MRT` Edits the tag list of the 1st property by adding a tag called `near mrt` if it does not already exist in the original tag list. Notice that the case of `MRT` is lowered to `mrt`.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
The following example is invalid:

`edit property 1 t/near school ta/4rm td/near mrt` You cannot reset the tag list of a property, in this case to ["near school"], *and* modify the resetted tag list by adding a tag called "4rm" and removing a tag called "near mrt". The rationale is that this may be potentially confusing.

</div>


### Viewing price histogram of listed properties and/or buyers : `stat`

Creates a pop-up with the price histogram of the currently listed properties and/or buyers in the view.

Format: `stat [(property | buyer)]`

![stat example](images/StatUi.png)

* Entering another `stat` command while the existing one is open  replaces the view in the pop-up window.
* If only buyers or only properties are visible, `stat` automatically presents the only buyers/only properties view.

### Locating properties by name: `find`

Finds properties or buyers whose names contain any of the given keywords and whose tag list contain all of the specified tags in the **currently displayed list**.

Format: `find (properties | buyers) [KEYWORDS] [t/TAG_TO_MATCH]… [$min/MIN_PRICE] [$max/MAX_PRICE]`

* Finds only properties or buyers in the currently displayed list

    e.g If `find properties hillview` return properties `Hillview` and `Hillview Rise`, then applying another find command `find properties grove` will return an empty list, even if PropertyWhiz has a property `Grove`.
* The keyword search is case-insensitive. e.g `hillview` will match `Hillview`
* The order of the keywords does not matter. e.g. `Hillview Rise` will match `Rise Hillview`
* Only the property name is searched.
* Only full words will be matched e.g. `Han` will not match `Hillview`
* The tag search is case-insensitive, e.g. both `t/mrt`, `t/MRT` will match the `mrt` tag.
* Properties matching at least one keyword (i.e. `OR` search) and matching all the tags (i.e. `AND` search) will be returned.
    * e.g. For keywords, `Hillview Rise` will return `Hillview Grove`, `Rise Rivervale`
    * e.g. For tags, `t/4rm t/near school` will return properties with both `4rm` tag, and `near school` tag.
* The price search is inclusive of the specified number
  * e.g. `find properties $min/10000` will return properties that are at least $10000
  * e.g. `find properties $max/100000` will return properties that are at most $100000
* Only one `$min/` and `$max/` is allowed in the input
  * e.g. `find properties $min/1000 $max/100000` is valid
  * e.g. `find properties $min/10000 $min/1999999 $max/100000` is invalid
  
Examples:
* `find properties Jurong` returns properties `jurong` and `Jurong East`
* `find buyers Sally` returns buyers `sally` and `Sally Brown`
* `find properties Jurong t/4rm t/near school` returns properties `jurong [4rm] [near school] [near mrt]` and `Jurong East [4rm] [near school] [near mrt]` but not `jurong [4rm] [near mrt]`
* `find properties t/4rm t/near school` returns properties `jurong [4rm] [near school] [near mrt]` and `Clementi [4rm] [near school] [near mrt]`
* `find buyers Sally t/4rm t/near school` returns buyers `Sally [4rm] [near school] [quiet]` and `sally brown [4rm] [near school]`
* `find properties $min/10000 $max/1000000` returns properties that are at least $10000 and at most $1000000

------------------

### Deleting a property/buyer : `delete`

Deletes the specified property/buyer from PropertyWhiz.

Format: `delete (property | buyer) INDEX`

* Deletes the property/buyer at the specified `INDEX`.
* The index refers to the index number shown in the displayed property/buyer list.
* The index **must be a positive integer** 1, 2, 3, …

Examples:
* `list` followed by `delete property 2` deletes the 2nd property in PropertyWhiz.
* `find East Coast` followed by `delete property 1` deletes the 1st property in the results of the `find` command.

------------------

### Sorting properties/buyers: `sort`

Sorts the properties / buyers in PropertyWhiz.

Format: `sort (properties | buyers) (price | name) (asc | desc)`

* Sort the properties in the **current** view based on properties `price`/`name` in `asc`(ascending) / `desc`(descending) order
* Sort the buyers in the **current** view based on buyers `price`/`name` in `asc`(ascending) / `desc`(descending) order

Examples:

* `sort properties price asc` returns the property list sorted by price in ascending order
* `sort buyers name desc` returns the buyer list sorted by name in descending order

### Matching properties and buyers: `match`

Matches properties and buyers to one another.

Format: `match ( auto | property INDEX | buyer INDEX )`

#### One to many matching of property to buyers

![Matching one to many](images/MatchOneToManyUi.png)

Matches compatible buyers to a specified property, displayed in descending order of desirability.

Format: `match property INDEX`

* A buyer is compatible with a property if the buyer's budget is greater than or equal to the property's selling price.
* When 2 buyers, say `A` and `B` are both compatible with a property, then `A` is more desirable than `B` if `A` has more tags in common with the property than `B`. This is because a buyer's tags represents what the buyer would want in a property, and a property's tags represents the features the property has to offer.
* When 2 buyers have the same number of tags in common with a property, the buyer with a higher budget is ranked higher in desirability.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**

The matching is done on the currently displayed buyer list. In other words, if you have filtered buyers for example, using the `find` command, then the potential matches for `match property 1` (the first displayed property) will only come from the filtered buyer list.

To illustrate, suppose you have 5 buyers in total (Adam, Ben, Carl, Daniel, Elle), and you have filtered the buyers to 3 (Adam, Ben, Carl). Then `match property 1` will only examine the 3 buyers (Adam, Ben, Carl). Even if Daniel or Elle is compatible with the first displayed property, they will not be considered in the matching.

</div>

TODO: This part can be moved to a more general area.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
You can use the `list` command to reset the display lists to display all the available buyers before using `match property`. This will find compatible buyers from the full pool of available buyers.
</div>

Example:<br>
Suppose there are 5 properties currently displayed in the property list. `match property 2` matches all buyers compatible with the second displayed property. Let's call this property "Greendale Heights" and assume it has a selling price of `1,000,000` and has tags `4rm`, `near school`. Then a buyer whose budget is `900,000` would not be compatible, and a buyer whose budget is `1,100,000` is compatible.<br>
Suppose 3 buyers, "Richard", "Sam", and "Tim" , are both compatible with Greendale Heights. Richard has tags `5rm`, `far from school`, Sam has one tag `4rm`, and Tim has tags `4rm`, `near school`. Then Tim has the greatest number of tags in common and is the most desirable buyer match, whereas Richard has the least number of tags in common and is the least desirable buyer match.

#### One to many matching of buyer to properties

Matches compatible properties to a specified buyer, displayed in descending order of desirability.

Format: `match buyer INDEX`

* A property is compatible with a buyer if the property's selling price is lower than the buyer's budget, i.e. the property is within the budget of the buyer.
* When 2 properties, say `A` and `B` are both compatible with a buyer, then `A` is more desirable than `B` if `A` has more tags in common with the buyer than `B`.
* When 2 properties have the same number of tags in common with a buyer, the property with a lower selling price is ranked higher in desirability, in other words, cheaper is better.
* Similar to `match property`, the matching for `match buyer` is done on the currently displayed property list. You can use the `list` command to reset the display lists to display all the available properties before using `match buyer`.

Example:<br>
Suppose there are 5 buyers currently displayed in the buyer list. `match buyer 2` matches all properties compatible with the second displayed buyer. Let's call this buyer "Sam" and assume Sam has a budget of `1,000,000` and has tags `4rm`, `near school`. Then a property whose selling price is `1,100,000` would not be compatible, and a property whose selling price is `900,000` is compatible.<br>
Suppose 3 properties, "Dee Gardens", "Olive Gardens", and "Pear Gardens" are all compatible with Sam. Dee Gardens has tags `5rm`, `far from school`, Olive Gardens has one tag `4rm`, and Pear Gardens has tags `4rm`, `near school`. Then Pear Gardens has the greatest number of tags in common and is the most desirable property match, whereas Dee Gardens has the least number of tags in common and is the least desirable property match.

#### Intelligent matching of properties and buyers

![Matching auto](images/MatchAutoUi.png)

The `match auto` command instructs PropertyWhiz to automatically match buyers to properties.

Upon entering `match auto`, PropertyWhiz will intelligently pair properties with buyers based on their compatibility. The matches will then be displayed to you starting with the most compatible pairings at the top.

PropertyWhiz determines compatibility based on the number of tags in common, the buyer's budget, as well as the property price. Matches where the buyer and property have more tags in common are considered more compatible. Likewise for matches where the property price is within the buyer's budget.

After running `match auto`, enter `back` into the command box to return to the previously shown list of buyers and properties.

### Importing data from csv file : `import`

Imports buyers or properties from csv file.

Format: `import buyers` or `import properties`

* You can select the import file location from a pop-up dialog box.

TODO: Add example of valid csv

------------------

### Exporting data to csv file : `export`

Exports buyers or properties from csv file.

Format: `export buyers` or `export properties`

* You can select the export file location from a pop-up dialog box.

Example result of  `export property`
```
"Name","Address","Seller Name","Phone","Email","Price","Tags"
"Geylang St 29","Blk 30 Geylang Street 29, #06-40","Alex Yeoh","87438807","alexyeoh@example.com","654321","hdb,4-rm"
"Dee Gardens","Blk 30 Lorong 3 Serangoon Gardens, #07-18","Beatrice Yu","99272758","berniceyu@example.com","654321","hdb,5-rm"
```

Example result of `export buyer`
```
"Name","Phone","Email","Budget","Tags"
"Alibaba","61234567","alibaba@baba.com","1999999","condo,landed"
```

------------------

### Clearing all entries : `clear`

Clears all entries from PropertyWhiz.

Format: `clear`

------------------

### Exiting the program : `exit`

Exits the program.

Format: `exit`

------------------

### Saving the data

PropertyWhiz's data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

------------------

## Advanced features

This section contains features intended for advanced users.

### Editing the data file

PropertyWhiz's data are saved as a JSON file `[JAR file location]/data/propertywhiz.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, PropertyWhiz will discard all data and start with an empty data file at the next run.
</div>

### Multi-command input

You may copy and paste multiple lines of commands into the command box. Press the Enter key to execute the first command and autofill the next into the command box. This continues until you enter a different command or all commands have been executed.

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous PropertyWhiz home folder.
