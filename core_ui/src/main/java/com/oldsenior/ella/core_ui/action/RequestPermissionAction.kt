package com.oldsenior.ella.core_ui.action


import androidx.fragment.app.DialogFragment
import com.oldsenior.ella.core_ui.alert.AlertAction
import kotlinx.android.parcel.Parcelize


@Parcelize
class RequestPermissionAction(
    private val permission: String,
    private val permissionRequestKey: Int
) : AlertAction {

    override fun onAction(dialogFragment: DialogFragment) {
        dialogFragment.targetFragment?.requestPermissions(
            arrayOf(permission),
            permissionRequestKey
        )
    }
}