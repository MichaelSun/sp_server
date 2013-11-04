package com.sp.domain



import org.junit.*
import grails.test.mixin.*

@TestFor(GodAppItemController)
@Mock(GodAppItem)
class GodAppItemControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/godAppItem/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.godAppItemInstanceList.size() == 0
        assert model.godAppItemInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.godAppItemInstance != null
    }

    void testSave() {
        controller.save()

        assert model.godAppItemInstance != null
        assert view == '/godAppItem/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/godAppItem/show/1'
        assert controller.flash.message != null
        assert GodAppItem.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/godAppItem/list'

        populateValidParams(params)
        def godAppItem = new GodAppItem(params)

        assert godAppItem.save() != null

        params.id = godAppItem.id

        def model = controller.show()

        assert model.godAppItemInstance == godAppItem
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/godAppItem/list'

        populateValidParams(params)
        def godAppItem = new GodAppItem(params)

        assert godAppItem.save() != null

        params.id = godAppItem.id

        def model = controller.edit()

        assert model.godAppItemInstance == godAppItem
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/godAppItem/list'

        response.reset()

        populateValidParams(params)
        def godAppItem = new GodAppItem(params)

        assert godAppItem.save() != null

        // test invalid parameters in update
        params.id = godAppItem.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/godAppItem/edit"
        assert model.godAppItemInstance != null

        godAppItem.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/godAppItem/show/$godAppItem.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        godAppItem.clearErrors()

        populateValidParams(params)
        params.id = godAppItem.id
        params.version = -1
        controller.update()

        assert view == "/godAppItem/edit"
        assert model.godAppItemInstance != null
        assert model.godAppItemInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/godAppItem/list'

        response.reset()

        populateValidParams(params)
        def godAppItem = new GodAppItem(params)

        assert godAppItem.save() != null
        assert GodAppItem.count() == 1

        params.id = godAppItem.id

        controller.delete()

        assert GodAppItem.count() == 0
        assert GodAppItem.get(godAppItem.id) == null
        assert response.redirectedUrl == '/godAppItem/list'
    }
}
