package com.lambdaschool.congressdata

import com.lambdaschool.congressdataapiaccess.CongresspersonOverview

class OfficialOverview {
    private var firstName: String? = null
    private var middleName: String? = null
    private var lastName: String? = null
    var party: String? = null
        private set
    var state: String? = null
        private set
    var displayName: String? = null
        private set
    var id: String? = null
        private set

    constructor(firstName: String, middleName: String, lastName: String, party: String, state: String, id: String) {
        this.firstName = firstName
        this.middleName = middleName
        this.lastName = lastName
        this.party = party
        this.state = state
        this.displayName = buildDisplayName()
        this.id = id
    }

    constructor(congresspersonOverview: CongresspersonOverview) {
        this.firstName = congresspersonOverview.firstName
        this.middleName = congresspersonOverview.middleName
        this.lastName = congresspersonOverview.lastName
        this.party = congresspersonOverview.party
        this.state = congresspersonOverview.state
        this.displayName = buildDisplayName()
        this.id = congresspersonOverview.id
    }

    private fun buildDisplayName(): String {
        val nameBuilder = StringBuilder()
        nameBuilder.append(firstName).append(" ")
        if (middleName != "null") {
            nameBuilder.append(middleName).append(" ")
        }
        nameBuilder.append(lastName)
        return nameBuilder.toString().capitalize()
    }
}
