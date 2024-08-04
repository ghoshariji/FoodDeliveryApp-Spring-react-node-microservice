import {
  Disclosure,
  DisclosureButton,
  DisclosurePanel,
  Menu,
  MenuButton,
  MenuItem,
  MenuItems,
} from "@headlessui/react";
import { Bars3Icon, BellIcon, XMarkIcon } from "@heroicons/react/24/outline";
import { Link, useNavigate } from "react-router-dom";
const user = {
  name: "Tom Cook",
  email: "tom@example.com",
  imageUrl:
    "https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80",
};
const navigation = [
  { name: "Home", href: "#", current: false },
  { name: "About", href: "/about-us", current: false },
  { name: "Restaurant", href: "#", current: false },
  { name: "Helpline", href: "/user-helpline", current: false },
];
const userNavigation = [
  { name: "Your Profile", href: "/user-profile" },
  { name: "Sign out", href: "#" },
];

function classNames(...classes) {
  return classes.filter(Boolean).join(" ");
}

export default function Afternav() {
  const navigate = useNavigate();
  return (
    <>
      <div className="min-h-full">
        <Disclosure as="nav" className="bg-gray-800">
          <div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
            <div className="flex h-16 items-center justify-between">
              <div className="flex items-center">
                <div className="flex-shrink-0">
                  <img
                    alt="Your Company"
                    src="data:image/jpeg;base64,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"
                    className="h-8 w-8"
                  />
                </div>
                <div className="hidden md:block">
                  <div className="ml-10 flex items-baseline space-x-4">
                    {navigation.map((item) => (
                      <Link
                        key={item.name}
                        to={item.href}
                        aria-current={item.current ? "page" : undefined}
                        className={classNames(
                          item.current
                            ? "bg-gray-900 text-white"
                            : "text-gray-300 hover:bg-gray-700 hover:text-white",
                          "rounded-md px-3 py-2 text-sm font-medium"
                        )}
                      >
                        {item.name}
                      </Link>
                    ))}
                  </div>
                </div>
              </div>
              <div className="hidden md:block">
                <div className="ml-4 flex items-center md:ml-6">
                  <button
                    type="button"
                    className="relative rounded-full bg-gray-800 p-1 text-gray-400 hover:text-white focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-800"
                    onClick={() => navigate("/user-cart")}
                  >
                    <span className="absolute -inset-1.5" />
                    <span className="sr-only">Cart</span>
                    <BellIcon aria-hidden="true" className="h-6 w-6" />
                  </button>

                  {/* Profile dropdown */}
                  <Menu as="div" className="relative ml-3">
                    <div>
                      <MenuButton className="relative flex max-w-xs items-center rounded-full bg-gray-800 text-sm focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-800">
                        <span className="absolute -inset-1.5" />
                        <span className="sr-only">Open user menu</span>
                        <img
                          alt=""
                          src={user.imageUrl}
                          className="h-8 w-8 rounded-full"
                        />
                      </MenuButton>
                    </div>
                    <MenuItems
                      transition
                      className="absolute right-0 z-10 mt-2 w-48 origin-top-right rounded-md bg-white py-1 shadow-lg ring-1 ring-black ring-opacity-5 transition focus:outline-none data-[closed]:scale-95 data-[closed]:transform data-[closed]:opacity-0 data-[enter]:duration-100 data-[leave]:duration-75 data-[enter]:ease-out data-[leave]:ease-in"
                    >
                      {userNavigation.map((item) => (
                        <MenuItem key={item.name}>
                          <Link
                            to={item.href}
                            className="block px-4 py-2 text-sm text-gray-700 data-[focus]:bg-gray-100"
                          >
                            {item.name}
                          </Link>
                        </MenuItem>
                      ))}
                    </MenuItems>
                  </Menu>
                </div>
              </div>
              <div className="-mr-2 flex md:hidden">
                {/* Mobile menu button */}
                <DisclosureButton className="group relative inline-flex items-center justify-center rounded-md bg-gray-800 p-2 text-gray-400 hover:bg-gray-700 hover:text-white focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-800">
                  <span className="absolute -inset-0.5" />
                  <span className="sr-only">Open main menu</span>
                  <Bars3Icon
                    aria-hidden="true"
                    className="block h-6 w-6 group-data-[open]:hidden"
                  />
                  <XMarkIcon
                    aria-hidden="true"
                    className="hidden h-6 w-6 group-data-[open]:block"
                  />
                </DisclosureButton>
              </div>
            </div>
          </div>

          <DisclosurePanel className="md:hidden">
            <div className="space-y-1 px-2 pb-3 pt-2 sm:px-3">
              {navigation.map((item) => (
                <DisclosureButton
                  key={item.name}
                  as="a"
                  href={item.href}
                  aria-current={item.current ? "page" : undefined}
                  className={classNames(
                    item.current
                      ? "bg-gray-900 text-white"
                      : "text-gray-300 hover:bg-gray-700 hover:text-white",
                    "block rounded-md px-3 py-2 text-base font-medium"
                  )}
                >
                  {item.name}
                </DisclosureButton>
              ))}
            </div>
            <div className="border-t border-gray-700 pb-3 pt-4">
              <div className="flex items-center px-5">
                <div className="flex-shrink-0">
                  <img
                    alt=""
                    src={user.imageUrl}
                    className="h-10 w-10 rounded-full"
                  />
                </div>
                <div className="ml-3">
                  <div className="text-base font-medium leading-none text-white">
                    {user.name}
                  </div>
                  <div className="text-sm font-medium leading-none text-gray-400">
                    {user.email}
                  </div>
                </div>
                <button
                  type="button"
                  className="relative ml-auto flex-shrink-0 rounded-full bg-gray-800 p-1 text-gray-400 hover:text-white focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-800"
                  onClick={() => navigate("/user-cart")}
                >
                  <span className="absolute -inset-1.5" />
                  <span className="sr-only">Cart</span>
                  <BellIcon aria-hidden="true" className="h-6 w-6" />
                </button>
              </div>
              <div className="mt-3 space-y-1 px-2">
                {userNavigation.map((item) => (
                  <DisclosureButton
                    key={item.name}
                    as="a"
                    href={item.href}
                    className="block rounded-md px-3 py-2 text-base font-medium text-gray-400 hover:bg-gray-700 hover:text-white"
                  >
                    {item.name}
                  </DisclosureButton>
                ))}
              </div>
            </div>
          </DisclosurePanel>
        </Disclosure>
      </div>
    </>
  );
}
