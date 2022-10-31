package ru.melonhell.umpa.core.event

import ru.melonhell.umpa.core.wrappers.UmpaPluginWrapper

class TestPluginWrapper : UmpaPluginWrapper() {
    override val handle = "random shit"
}